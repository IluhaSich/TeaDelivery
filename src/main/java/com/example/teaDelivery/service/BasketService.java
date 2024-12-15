package com.example.teaDelivery.service;

import com.example.teaDelivery.dto.BasketDto;
import com.example.teaDelivery.entity.Basket;
import com.example.teaDelivery.repository.BasketRepository;
import io.micrometer.common.lang.NonNull;
import org.springframework.stereotype.Service;


@Service
public class BasketService {
    private final BasketRepository basketRepository;

    public BasketService(BasketRepository basketRepository) {
        this.basketRepository = basketRepository;
    }

    public void createBasket(@NonNull Basket basket) {
        if (basketRepository.existsById(basket.getId().toString())) {
            return;
        }
        basket = new Basket();
        basket.setId(0L);
        basket.setTotalPrice(100);
        basketRepository.save(basket);
    }

    public Basket getBasket(@NonNull String id) {
        return basketRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(String.format("Basket not found for id %s", id)));
    }

    //
    //
    //
//    private final RedisRepositoryImpl basketRepository;
//
//    public BasketService(RedisRepositoryImpl basketRepository) {
//        this.basketRepository = basketRepository;
//    }
//
////    public BasketService(BasketRepository basketRepository) {
////        this.basketRepository = basketRepository;
////    }
//
//    //TODO: return BasketDto
//    public Basket getBasket(String userId){
////        return basketRepository.findById(userId).orElse(new Basket(Long.parseLong(userId)));
//        return null;
//    }
//
//    public void addItemToBasket(String userId) {
////        Basket basket = basketRepository.findById(userId).orElse(new Basket(Long.parseLong(userId)));
//        //TODO: change parameters
////        basket.getItems().add(new Basket.BasketItem("name", 10.0,10.0,9.0));
////        basketRepository.save(basket);
//    }
//
//    public void removeItemFromBasket(String userId) {
////        Basket basket = basketRepository.findById(userId).orElse(new Basket(Long.parseLong(userId)));
//        //TODO: change parameters
////        basket.getItems().remove(new Basket.BasketItem("name", 10.0,10.0,9.0));
////        basketRepository.save(basket);
//    }
}
