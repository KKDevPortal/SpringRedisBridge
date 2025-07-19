package com.kkdevprotal.SpringRedisBridge.controller;

import com.kkdevprotal.SpringRedisBridge.entity.Product;
import com.kkdevprotal.SpringRedisBridge.repository.ProductRepository;
import com.kkdevprotal.SpringRedisBridge.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ProductController {

    @Autowired
    ProductService service;

    @PostMapping("/product")
    @CachePut(key = "#id", value = "Product")
    public Product save(@RequestBody Product product) {
        return service.save(product);
    }

    @GetMapping("/product")
    @Caching
    public List<?> getAllProduct() {
        return service.getAllProduct();
    }

    @GetMapping("/product/{id}")
    @Cacheable(key = "#id",value = "Product")
    public Product getProductById(@PathVariable int id) {
        return service.getProductById(id);
    }

    // caching with condition
    @GetMapping("/product/condition/{id}")
    @Cacheable(key = "#id",value = "Product", unless = "#result.price>1000")
    public Product getProductByIdWithCondition(@PathVariable int id) {
        return service.getProductById(id);
    }

    @DeleteMapping("/product/{id}")
    @CacheEvict(key="#id", value = "Product")
    public String removeProductById(@PathVariable int id) {
        return service.removeProductById(id);
    }

}
