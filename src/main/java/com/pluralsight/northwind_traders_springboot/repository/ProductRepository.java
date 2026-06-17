package com.pluralsight.northwind_traders_springboot.repository;

import com.pluralsight.northwind_traders_springboot.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    // BONUS: Spring Data JPA auto-implements these from the method name
    List<Product> findByCategory(String category);

    List<Product> findByNameContainingIgnoreCase(String name);
}