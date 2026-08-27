package com.springboot.app.springboot_di.services;

import java.util.List;
import java.util.stream.Collectors;

// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.springboot.app.springboot_di.models.Product;
import com.springboot.app.springboot_di.repositories.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {
    @Value("${spring.config.tax}")
    private Double tax;
    // Inyección por atributo
    // @Autowired
    // private ProductRepository repository;

    //Intección por constructor
    private ProductRepository repository;

    public ProductServiceImpl(@Qualifier("productJson") ProductRepository repository) {
        this.repository = repository;
    }

    //Intección por setter
    // private ProductRepository repository;

    // @Autowired
    // public void setRepository(ProductRepository repository) {
    //     this.repository = repository;
    // }
    

    @Override
    public List<Product> findAll() {
        return repository.findAll().stream().map(p -> {
            Double priceInt = p.getPrice() * tax;
            Product newProduct = (Product) p.clone();
            newProduct.setPrice(priceInt.longValue());
            return newProduct;
            
            // p.setPrice(priceInt.longValue());
            // return p;
        }).collect(Collectors.toList());
    }


    @Override
    public Product findById(Long id) {
        return repository.findById(id);
    }





}
