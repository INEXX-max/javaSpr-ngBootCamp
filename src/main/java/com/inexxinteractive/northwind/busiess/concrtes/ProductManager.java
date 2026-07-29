package com.inexxinteractive.northwind.busiess.concrtes;

import com.inexxinteractive.northwind.busiess.abstracts.IProductService;
import com.inexxinteractive.northwind.dataAccess.abstracts.IProductDao;
import com.inexxinteractive.northwind.entities.concretes.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service// bu class service gorevi gorecek bussines kısmı buradan sorulacak
public class ProductManager implements IProductService {
    @Autowired
    public ProductManager(IProductDao productDao)  {
        super();
        this.productDao = productDao;
    }

    private IProductDao productDao;

    @Override
    public List<Product> getAll() {
        return this.productDao.findAll();
    }
}
