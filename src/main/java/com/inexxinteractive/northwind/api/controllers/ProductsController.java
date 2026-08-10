package com.inexxinteractive.northwind.api.controllers;

import com.inexxinteractive.northwind.busiess.abstracts.IProductService;
import com.inexxinteractive.northwind.core.utilits.results.DataResults;
import com.inexxinteractive.northwind.core.utilits.results.Results;
import com.inexxinteractive.northwind.entities.concretes.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductsController {

    private final IProductService productService;

    @Autowired
    public ProductsController(IProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/")
    public String home() {
        return "INEXX INTERACTIVE INC. DataBase başarıyla çalışıyor.";
    }

    @GetMapping("/getall")
    public DataResults<List<Product>> getAll() {
        return this.productService.getAll();
    }

    @GetMapping("/getAllByPage")
    public DataResults<List<Product>> getAll(int pageNo, int pageSize) {
        return this.productService.getAll(pageNo, pageSize);
    }

    @PostMapping("/add")
    public Results add(@RequestBody Product product) {
        return this.productService.add(product);
    }

    @GetMapping("/getByProductName")
    public DataResults<Product> getByProductName(@RequestParam String productName) {
        return this.productService.getByProductName(productName);
    }

    @GetMapping("/getByProductNameAndCategoryId")
    public DataResults<Product> getByProductNameAndCategoryId(@RequestParam String productName,
                                                              @RequestParam int categoryId) {
        return this.productService.getByProductNameAndCategoryId(productName, categoryId);
    }

    @GetMapping("/getByProductNameOrCategoryId")
    public DataResults<List<Product>> getByProductNameOrCategoryId(@RequestParam String productName,
                                                                   @RequestParam int categoryId) {
        return this.productService.getByProductNameOrCategoryId(productName, categoryId);
    }

    @GetMapping("/getByProductNameContains")
    public DataResults<List<Product>> getByProductNameContains(@RequestParam String productName) {
        return this.productService.getByProductNameContains(productName);
    }

    @GetMapping("/getByProductNameStartsWith")
    public DataResults<List<Product>> getByProductNameStartsWith(@RequestParam String productName) {
        return this.productService.getByProductNameStartsWith(productName);
    }

    @GetMapping("/getByNameAndCategory")
    public DataResults<List<Product>> getByNameAndCategory(@RequestParam String productName,
                                                           @RequestParam int categoryId) {
        return this.productService.getByNameAndCategory(productName, categoryId);
    }

}