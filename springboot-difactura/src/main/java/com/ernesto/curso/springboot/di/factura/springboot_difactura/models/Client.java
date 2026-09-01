package com.ernesto.curso.springboot.di.factura.springboot_difactura.models;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Component
// @SessionScope // Nos cambia el scope a una sola sesión ya sea del navegador por ejemplo.
@RequestScope
@JsonIgnoreProperties({"advisors","targetSource"}) // como ya no tiene propiedades get y es de nivel superior necesita propiedades para serializar a JSON; atributos residuales

public class Client {
    @Value("${client.name}")
    private String name;
    @Value("${client.lastName}")
    private String lastName;


    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    
}
