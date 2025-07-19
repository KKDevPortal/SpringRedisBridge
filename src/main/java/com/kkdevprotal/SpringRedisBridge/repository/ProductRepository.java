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
        System.out.println("Product to be saved : " + product.toString());
        template.opsForHash().put(HASH_KEY, product.getId(), product);
        return product;
    }

    public List<Object> finalAll() {
        return template.opsForHash().values(HASH_KEY);
    }

    public Product findProductById(int id) {
        return (Product) template.opsForHash().get(HASH_KEY, id);
    }

    public String deleteProduct(int id) {
        template.opsForHash().delete(HASH_KEY, id);

        return "Product removed";
    }
}
