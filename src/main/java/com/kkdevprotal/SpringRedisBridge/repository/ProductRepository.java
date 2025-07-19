package com.kkdevprotal.SpringRedisBridge.repository;

import com.kkdevprotal.SpringRedisBridge.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;

@Repository
public class ProductRepository {

    public static final String HASH_KEY = "Product";

    @Autowired
    private RedisTemplate<String, Object> template;

    public Product save(Product product) {
        System.out.println("Product to be saved in db: " + product.toString());
        template.opsForHash().put(HASH_KEY, product.getId(), product);
        return product;
    }

    public List<Object> finalAll() {
        System.out.println("Finding all product from db ...");
        return template.opsForHash().values(HASH_KEY);
    }

    public Product findProductById(int id) {
        System.out.println("Finding product by id from db : " + id);
        return (Product) template.opsForHash().get(HASH_KEY, id);
    }

    public String deleteProduct(int id) {
        System.out.println("Product to be deleted by id in db: " + id);
        template.opsForHash().delete(HASH_KEY, id);

        return "Product removed";
    }
}
