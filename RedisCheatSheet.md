## Navigate to redis container
> docker exec -it redisSQ redis-cli

## If accessing through bash
> docker exec -it redisSQ bash
> redis-cli -a 'c@lib3r'

## if password then auth
> AUTH c@lib3r

## Get all keys
> KEYS *

##  View all fields and values in the "Product" hash:
> HGETALL Product

## Useful command
| Command            | Description                   |
| ------------------ | ----------------------------- |
| `HGET Product 101` | Get the product with ID `101` |
| `HKEYS Product`    | Get all product IDs           |
| `HLEN Product`     | Get number of products        |
| `HDEL Product 101` | Delete product with ID `101`  |
| `DEL Product`      | Delete entire product hash    |
