package com.springboot.app.springboot_di.repositories;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Repository;
// import org.springframework.web.context.annotation.RequestScope;
// import org.springframework.web.context.annotation.SessionScope;

import com.springboot.app.springboot_di.models.Product;

// @RequestScope //Contexto por petición http del usuario.
// @SessionScope //Contexto de sesion hhtp
// @Primary
@Repository("productList")
public class ProductRepositoryImpl implements ProductRepository{
    //Capa de Acceso a Datos (Datos)
    private List<Product> data;

    public ProductRepositoryImpl() {
        this.data = Arrays.asList(
            new Product(1L, "Monitor",234L),
            new Product(2L, "Escritorio",5000L),
            new Product(3L, "Mouse",4700L),
            new Product(4L, "Teclado",8500L)
        );
    }

    @Override
    public List<Product> findAll(){
        return data;
    }

    @Override
    public Product findById (Long id){
        return data.stream().filter(p -> p.getId().equals(id)).findFirst().orElse(null);
    }
    
}
