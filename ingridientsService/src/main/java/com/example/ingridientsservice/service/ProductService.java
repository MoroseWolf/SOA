package com.example.ingridientsservice.service;

import com.example.ingridientsservice.model.Product;

import java.util.List;

public interface ProductService {

    void create(Product product);

    List<Product> readAll();

    Product read(Long id);

    boolean update(Product product, Long id);

    boolean delete(Long id);
}
