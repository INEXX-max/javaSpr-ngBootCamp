package com.inexxinteractive.northwind.api.controllers;

import com.inexxinteractive.northwind.busiess.abstracts.IProductService;
import com.inexxinteractive.northwind.core.utilits.results.DataResults;
import com.inexxinteractive.northwind.core.utilits.results.Results;
import com.inexxinteractive.northwind.entities.concretes.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public DataResults<List<Product>> getAll() {

        return this.productService.getAll();
    }
    @GetMapping("/")
    public String home() {
        return "INEXX INTERACTIVE INC. DataBase başarıyla çalışıyor. ";
    }


    @PostMapping("/add")// post kelime anlamı göndemrek burada sen  birşey gönderiyosusn
    public Results add(@RequestBody Product product){
        return  this.productService.add(product);

        // REQUESTBODY amacı hesm istek atarhemde datayı gönderisi json fortmatında
    }

    @GetMapping("/getByProductName")
    public DataResults<Product> getByProductName(@RequestParam String productName){
        return this.productService.getByProductName(productName);
    }

    @GetMapping("/getByProductNameAndCategoryId")
    public DataResults<Product>
    getByProductNameAndCategoryId(@RequestParam("productName")  String productName,@RequestParam int categoryId){
        return  this.productService.getByProductNameAndCategoryId(productName,categoryId);
    }


}
