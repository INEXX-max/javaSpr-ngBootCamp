package com.inexxinteractive.northwind.dataAccess.abstracts;

import com.inexxinteractive.northwind.entities.concretes.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductDao extends JpaRepository<Product,Integer> {
}
