package com.example.demoajax.service;

import com.example.demoajax.query.Demo;
import com.example.demoajax.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();

    void save(Product product);

    void delete(Long id);

    Long countProduct();

    Product findById(Long id);

    List<Demo> getDemo();
}
