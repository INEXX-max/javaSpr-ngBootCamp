package com.inexxinteractive.northwind.busiess.abstracts;

import com.inexxinteractive.northwind.core.entites.User;
import com.inexxinteractive.northwind.core.utilits.results.DataResults;
import com.inexxinteractive.northwind.core.utilits.results.Results;
import com.inexxinteractive.northwind.entities.concretes.Product;

import java.util.List;

public interface UserService {
    Results add(User user);
    DataResults <User> findByEmail(String email);
}
