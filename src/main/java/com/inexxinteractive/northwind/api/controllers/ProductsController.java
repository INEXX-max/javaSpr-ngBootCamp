package com.inexxinteractive.northwind.api.controllers;

import com.inexxinteractive.northwind.busiess.abstracts.IProductService;
import com.inexxinteractive.northwind.entities.concretes.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("/api/products")
public class ProductsController {

    private IProductService productService;



    @Autowired// GİDİP PROJEYİ TARAR  ve şunu yapar bizizm yermize new ler nesne üretir  bizim yerize
    public ProductsController(IProductService productService) {
        super();
        this.productService = productService;
    }


    @GetMapping("/getall")
    public List<Product> getAll() {

        return this.productService.getAll();
    }
    @GetMapping("/")
    public String home() {
        return "INEXX INTERACTIVE INC. DataBase başarıyla çalışıyor. ";
    }

}
