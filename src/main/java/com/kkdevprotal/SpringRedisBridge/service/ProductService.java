package com.kkdevprotal.SpringRedisBridge.service;

import com.kkdevprotal.SpringRedisBridge.entity.Product;
import com.kkdevprotal.SpringRedisBridge.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.UUID;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public Product save(@RequestBody Product product) {
        return repository.save(product);
    }

    public List<Object> getAllProduct() {
        return repository.finalAll();
    }

    public Product getProductById(@PathVariable int id) {
        return repository.findProductById(id);
    }

    public String removeProductById(@PathVariable int id) {
        return repository.deleteProduct(id);
    }
}
