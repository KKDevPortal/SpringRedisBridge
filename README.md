# SpringRedisBridge
A simple messaging bridge using Spring Boot + Redis with REST 


# Curl
## Save product
```declarative
curl --location 'localhost:9192/api/v1/product' \
--header 'Content-Type: application/json' \
--data '{
    "id" : "105",
    "name" : "Mobile", 
    "qty" : 1,
    "price": 12000
}'
```

## Get all product
```declarative
curl --location 'localhost:9192/api/v1/product'
```

## Get product by id
```declarative
curl --location 'localhost:9192/api/v1/product/101'
```

## Delete product by id
```declarative
curl --location --request DELETE 'localhost:9192/api/v1/product/101'
```

## How Caching Works
### Spring’s cache abstraction (enabled via @EnableCaching) allows transparent caching using annotations:

- @Cacheable: Skips method execution if value exists in cache.
- @CachePut: Executes method and updates cache with result.
- @CacheEvict: Removes an entry from cache.
- @Caching: Composite annotation for combining multiple caching operations.

All caching in this project is backed by Redis, configured automatically via `spring.cache.type=redis`.