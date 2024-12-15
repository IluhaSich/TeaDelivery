package com.example.teaDelivery.entity;

import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;
import java.util.List;

@RedisHash("Basket")
//TODO: Serializable?
public class Basket extends BaseEntity {
    private double totalPrice;
    private double totalPriceWithDiscount;
    private List<BasketItem> items;

    public Basket() {
    }

    public Basket(Long userId) {
        setId(userId);
    }

    public static class BasketItem {
        private String name;
        private double cost;
        private double discount;
        private double finalPrice;

        public BasketItem() {
        }

        public BasketItem(String name, double cost, double discount, double finalPrice) {
            this.name = name;
            this.cost = cost;
            this.discount = discount;
            this.finalPrice = finalPrice;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getCost() {
            return cost;
        }

        public void setCost(double cost) {
            this.cost = cost;
        }

        public double getDiscount() {
            return discount;
        }

        public void setDiscount(double discount) {
            this.discount = discount;
        }

        public double getFinalPrice() {
            return finalPrice;
        }

        public void setFinalPrice(double finalPrice) {
            this.finalPrice = finalPrice;
        }
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public double getTotalPriceWithDiscount() {
        return totalPriceWithDiscount;
    }

    public void setTotalPriceWithDiscount(double totalPriceWithDiscount) {
        this.totalPriceWithDiscount = totalPriceWithDiscount;
    }

    public List<BasketItem> getItems() {
        return items;
    }

    public void setItems(List<BasketItem> items) {
        this.items = items;
    }
}
