package com.example.teaDelivery.repository;

import com.example.teaDelivery.entity.Basket;
import com.example.teaDelivery.repository.redis.RedisRepository;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BasketRepository extends CrudRepository<Basket,String> {
}
