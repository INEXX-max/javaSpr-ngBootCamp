package com.inexxinteractive.northwind.busiess.concrtes;

import com.inexxinteractive.northwind.busiess.abstracts.IProductService;
import com.inexxinteractive.northwind.core.utilits.results.DataResults;
import com.inexxinteractive.northwind.core.utilits.results.Results;
import com.inexxinteractive.northwind.core.utilits.results.SucessDataResult;
import com.inexxinteractive.northwind.core.utilits.results.SucessResult;
import com.inexxinteractive.northwind.dataAccess.abstracts.IProductDao;
import com.inexxinteractive.northwind.entities.concretes.Product;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Sort;


import java.util.List;

@Service
public class ProductManager implements IProductService {

    private final IProductDao productDao;

    @Autowired
    public ProductManager(IProductDao productDao) {
        this.productDao = productDao;
    }

    @Override
    public DataResults<List<Product>> getAll() {
        return new SucessDataResult<>(this.productDao.findAll(), "Datalar listelendi.");
    }

    @Override
    public DataResults<List<Product>> getAll(int pageNo, int pageSize) {
        Pageable pageable=  PageRequest.of(pageNo -1 ,pageSize);
        return new SucessDataResult<List<Product>>
        (this.productDao.findAll(pageable).getContent());

    }

    @Override
    public Results add(Product product) {
        this.productDao.save(product);
        return new SucessResult("Ürün başarıyla eklendi.");
    }

    @Override
    public DataResults<Product> getByProductName(String productName) {
        return new SucessDataResult<>(this.productDao.getByProductName(productName), "Ürün getirildi.");
    }

    @Override
    public DataResults<Product> getByProductNameAndCategoryId(String productName, int categoryId) {
        return new SucessDataResult<>(this.productDao.getByProductNameAndCategory_CategoryId(productName, categoryId), "Ürün getirildi.");
    }

    @Override
    public DataResults<List<Product>> getByProductNameOrCategoryId(String productName, int categoryId) {
        return new SucessDataResult<>(this.productDao.getByProductNameOrCategory_CategoryId(productName, categoryId), "Ürünler listelendi.");
    }

    @Override
    public DataResults<List<Product>> getByCategoryIdIn(List<Integer> categories) {
        return new SucessDataResult<>(this.productDao.getByCategory_CategoryIdIn(categories), "Ürünler listelendi.");
    }
    @Override
    public DataResults<List<Product>> getByProductNameContains(String productName) {
        return new SucessDataResult<>(this.productDao.getByProductNameContains(productName), "Ürünler listelendi.");
    }

    @Override
    public DataResults<List<Product>> getByProductNameStartsWith(String productName) {
        return null;
    }


    @Override
    public DataResults<List<Product>> getByNameAndCategory(String productName, int categoryId) {
        return new SucessDataResult<>(this.productDao.getByNameAndCategory(productName, categoryId), "Ürünler listelendi.");
    }
    @Override
    public DataResults<List<Product>> getAllSorted() {
        Sort sort = Sort.by(Sort.Direction.DESC, "productName");
        return new SucessDataResult<>(this.productDao.findAll(sort), "Başarılı");
    }


}