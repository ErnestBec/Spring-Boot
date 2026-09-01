package com.ernesto.curso.springboot.di.factura.springboot_difactura;

import java.util.List;
import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.ernesto.curso.springboot.di.factura.springboot_difactura.models.Item;
import com.ernesto.curso.springboot.di.factura.springboot_difactura.models.Product;

@Configuration
@PropertySource(value ="classpath:data.properties", encoding = "UTF-8")
public class AppConfig {

    @Bean("default")
    List<Item> itemsInvoice() {
        Product p1 = new Product("Ariel", 20);
        Product p2 = new Product("Downy", 25);
        return Arrays.asList(new Item(p1, 4), new Item(p2, 8));
    }

}
