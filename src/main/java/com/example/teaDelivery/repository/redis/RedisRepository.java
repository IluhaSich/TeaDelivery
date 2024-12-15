package com.example.teaDelivery.repository.redis;

import com.example.teaDelivery.entity.Basket;

import java.util.Map;

public interface RedisRepository {
    Map<Object,Object> findAllBaskets();
    void add(Basket basket);
    void delete(String id);
    Basket findBasket(String id);
}
