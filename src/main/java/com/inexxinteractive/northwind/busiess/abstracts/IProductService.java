package com.inexxinteractive.northwind.busiess.abstracts;

import com.inexxinteractive.northwind.core.utilits.results.DataResults;
import com.inexxinteractive.northwind.core.utilits.results.Results;
import com.inexxinteractive.northwind.entities.concretes.Product;

import java.util.List;

public interface IProductService {
    DataResults<List<Product>> getAll();
    Results add(Product product);









}
