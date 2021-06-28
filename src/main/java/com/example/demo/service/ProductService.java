package com.example.demo.service;

import com.example.demo.dao.ProductDao;
import com.example.demo.exception.ProductNotFoundException;
import com.example.demo.exception.UnauthorizedAccessException;
import com.example.demo.model.Product;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

// this class contains all the business logic of the product controller
@Service
public class ProductService implements ProductDao {

    private static Map<String, Product> productRepo = new HashMap<>();

    static {
        Product honey = new Product();
        honey.setId("1");
        honey.setName("HONEY");
        productRepo.put(honey.getId(), honey);

        Product orange = new Product();
        orange.setId("2");
        orange.setName("ORANGE");
        productRepo.put(orange.getId(), orange);
    }

    @Override
    public void createProduct(Product product) {
        productRepo.put(product.getId(), product);

    }

    @Override
    public void updateProduct(String id, Product product) {
        if(!productRepo.containsKey(id)) throw new ProductNotFoundException();
        productRepo.remove(id);
        productRepo.put(id, product);
    }

    @Override
    public void deleteProduct(String id) {
        if(!productRepo.containsKey(id)) throw new UnauthorizedAccessException();
        productRepo.remove(id);
    }

    @Override
    public Collection<Product> getProduct() {
        return productRepo.values();
    }
}
