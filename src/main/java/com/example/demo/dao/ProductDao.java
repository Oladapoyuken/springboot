package com.example.demo.dao;

// An interface to link the serviceController to it business logic

import com.example.demo.model.Product;

import java.util.Collection;

public interface ProductDao {
    public abstract void createProduct(Product product);
    public abstract void updateProduct(String id, Product product);
    public abstract void deleteProduct(String id);
    public abstract Collection<Product> getProduct();
}
