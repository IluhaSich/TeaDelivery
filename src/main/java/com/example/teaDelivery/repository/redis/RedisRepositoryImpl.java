package com.example.teaDelivery.repository.redis;

import com.example.teaDelivery.entity.Basket;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.Map;
@Repository
public class RedisRepositoryImpl implements RedisRepository{
    private static final String KEY = "Basket";
    private RedisTemplate<String, Object> redisTemplate;
    private HashOperations hashOperations;

    @Autowired
    public RedisRepositoryImpl(RedisTemplate<String, Object> redisTemplate){
        this.redisTemplate = redisTemplate;
    }
    @PostConstruct
    private void init(){
        hashOperations = redisTemplate.opsForHash();
    }

    @Override
    public Map<Object, Object> findAllBaskets() {
        return hashOperations.entries(KEY);
    }

    @Override
    public void add(Basket basket) {
        hashOperations.put(KEY,basket.getId(),basket.getItems());
    }

    @Override
    public void delete(String id) {
        hashOperations.delete(KEY,id);
    }

    @Override
    public Basket findBasket(String id) {
        return (Basket) hashOperations.get(KEY,id);
    }
}
