package com.inexxinteractive.northwind.core.DataAccess;

import com.inexxinteractive.northwind.core.entites.User;
import com.inexxinteractive.northwind.entities.concretes.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface  UserDao extends JpaRepository  <User,Integer> {
    User findByEmail(String email);
}
