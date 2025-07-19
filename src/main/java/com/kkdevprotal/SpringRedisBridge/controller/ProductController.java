package com.kkdevprotal.SpringRedisBridge.controller;

import com.kkdevprotal.SpringRedisBridge.entity.Product;
import com.kkdevprotal.SpringRedisBridge.repository.ProductRepository;
import com.kkdevprotal.SpringRedisBridge.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ProductController {

    @Autowired
    ProductService service;

    @PostMapping("/product")
    public Product save(@RequestBody Product product) {
        return service.save(product);
    }

    @GetMapping("/product")
    public List<?> getAllProduct() {
        return service.getAllProduct();
    }

    @GetMapping("/product/{id}")
    public Product getProductById(@PathVariable int id) {
        return service.getProductById(id);
    }

    @DeleteMapping("/product/{id}")
    public String removeProductById(@PathVariable int id) {
        return service.removeProductById(id);
    }

}
