package com.inexxinteractive.northwind.dataAccess.abstracts;

import com.inexxinteractive.northwind.entities.concretes.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IProductDao extends JpaRepository<Product, Integer> {

    Product getByProductName(String productName);

    Product getByProductNameAndCategory_CategoryId(String productName, int categoryId);

    List<Product> getByProductNameOrCategory_CategoryId(String productName, int categoryId);

    List<Product> getByCategory_CategoryIdIn(List<Integer> categories);

    List<Product> getByProductNameContains(String productName);

    List<Product> getByProductNameStartingWith(String productName);

    @Query("FROM Product p WHERE p.productName = :productName AND p.Category.categoryId = :categoryId")
    List<Product> getByNameAndCategory(@Param("productName") String productName, @Param("categoryId") int categoryId);
}