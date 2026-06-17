package com.pluralsight.northwind_traders_springboot.service;

import com.pluralsight.northwind_traders_springboot.model.Product;
import com.pluralsight.northwind_traders_springboot.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    // Constructor injection — Spring will automatically wire the repository
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // Get all products
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    // Get a single product by ID — returns an Optional so the controller
    // can decide what to do if the product doesn't exist (e.g. return 404)
    public Optional<Product> getProductById(Integer id) {
        return productRepository.findById(id);
    }

    // Add (save) a new product
    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    // Delete a product by ID
    public void deleteProduct(Integer id) {
        productRepository.deleteById(id);
    }

    // BONUS: Search by category
    public List<Product> getProductsByCategory(String category) {
        return productRepository.findByCategory(category);
    }

    // BONUS: Search by name (partial, case-insensitive)
    public List<Product> searchProductsByName(String name) {
        return productRepository.findByNameContainingIgnoreCase(name);
    }
}
