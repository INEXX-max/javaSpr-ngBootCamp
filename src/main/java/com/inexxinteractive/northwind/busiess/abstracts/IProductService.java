package com.inexxinteractive.northwind.busiess.abstracts;

import com.inexxinteractive.northwind.core.utilits.results.DataResults;
import com.inexxinteractive.northwind.core.utilits.results.DataResults;
import com.inexxinteractive.northwind.core.utilits.results.Results;
import com.inexxinteractive.northwind.core.utilits.results.Results;
import com.inexxinteractive.northwind.entities.concretes.Product;
import com.inexxinteractive.northwind.entities.dtos.ProductWithCategoryDto;
import com.inexxinteractive.northwind.entities.dtos.ProductWithCategoryDto;

import java.util.List;

public interface IProductService {

    DataResults<List<Product>> getAll();
    DataResults<List<Product>> getAll(int pageNo, int pageSize);
    DataResults<List<Product>> getAllSorted();
    Results add(Product product);

    DataResults<Product> getByProductName(String productName);

    DataResults<Product> getByProductNameAndCategoryId(String productName, int categoryId);

    DataResults<List<Product>> getByProductNameOrCategoryId(String productName, int categoryId);

    DataResults<List<Product>> getByCategoryIdIn(List<Integer> categories);

    DataResults<List<Product>> getByProductNameContains(String productName);



    DataResults<List<Product>> getByNameAndCategory(String productName, int categoryId);
    DataResults<List<ProductWithCategoryDto>> getProductWithCategoryDetails();
}