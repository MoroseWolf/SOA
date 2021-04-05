package com.example.ingridientsservice.repository;

import com.example.ingridientsservice.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
