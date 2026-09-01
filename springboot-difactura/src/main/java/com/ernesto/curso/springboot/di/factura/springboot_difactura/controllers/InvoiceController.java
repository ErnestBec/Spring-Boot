package com.ernesto.curso.springboot.di.factura.springboot_difactura.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ernesto.curso.springboot.di.factura.springboot_difactura.models.Client;
import com.ernesto.curso.springboot.di.factura.springboot_difactura.models.Invoice;

@RestController
@RequestMapping("/invoices")
public class InvoiceController {

    @Autowired
    private Invoice invoice;

    @GetMapping("/show")
    public Invoice show(){
        Client client =  new Client();
        client.setName(invoice.getClient().getName());
        client.setLastName(invoice.getClient().getLastName());

        Invoice newInvoice = new Invoice();
        newInvoice.setClient(client);
        newInvoice.setItems(invoice.getItems());
        newInvoice.setDescription(invoice.getDescription());
        return newInvoice;
    }
}
