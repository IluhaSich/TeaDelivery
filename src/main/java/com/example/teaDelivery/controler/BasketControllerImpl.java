package com.example.teaDelivery.controler;

import com.example.pr6c.controller.BasketController;
import com.example.teaDelivery.entity.Basket;
import com.example.teaDelivery.service.BasketService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Optional;

@Controller
@RequestMapping("/basket")
public class BasketControllerImpl implements BasketController {
    private final BasketService basketService;

    public BasketControllerImpl(BasketService basketService) {
        this.basketService = basketService;
    }

    @Override
    public String GetBasket(Model model) {
        return "";
    }

    @Override
    public void addTeaToBasket(Long id) {
    }

//    @GetMapping("/add")
////    @PostMapping("/cart/{userId}/add/{productId}/{quantity}")
//    public void addItemToCart(@PathVariable String userId) {
//        basketService.addItemToBasket(userId);
//    }
//
//    @GetMapping("/cart/{userId}")
//    public Basket getCart(@PathVariable String userId) {
//        return basketService.getBasket(userId);
//    }
//
//    @GetMapping("/remove")
////    @PostMapping("/cart/{userId}/remove/{productId}/{quantity}")
//    public void removeItemFromCart(@PathVariable String userId) {
//        basketService.removeItemFromBasket(userId);
//    }
}
