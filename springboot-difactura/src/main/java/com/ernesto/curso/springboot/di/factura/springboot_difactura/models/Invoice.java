package com.ernesto.curso.springboot.di.factura.springboot_difactura.models;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
public class Invoice {
    @Autowired
    private Client client;

    @Value("${invoice.description}")
    private String description;

    @Autowired
    @Qualifier("default")
    private List<Item> items;

    @PostConstruct // De jakarta
    public void init(){
        // se ejecuta cuando se crea el componente despues de que todos los atributos se inicializaron
        System.out.println("Creando el componente de la factura");
        client.setName(client.getName().concat(" Pepé"));
        description = description.concat(" del cliente: ").concat(client.getName()).concat(" ").concat(client.getLastName());
    }

    @PreDestroy 
    public void destroy(){
        //Se ejecuta antes de finaliza el uso del componente o destruirse (singleton por defecto) 
        System.out.println("Destruyendo el componente o bean factura");
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        items = items;
    }

    public int getTotal(){
        // for(Item item : items){
            //     total += item.getImport();
            // }
            
        return items.stream()
        .map(item -> item.getImport())
        .reduce(0, (sum, importe) -> sum + importe);
    }

}
