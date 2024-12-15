package com.example.teaDelivery.dto;


import com.example.teaDelivery.entity.Basket;

import java.util.List;

public class BasketDto extends BaseDto {
    private double totalPrice;
    private double totalPriceWithDiscount;
    private List<Basket.BasketItem> items;

    public BasketDto(double totalPrice, double totalPriceWithDiscount, List<Basket.BasketItem> items) {
        this.totalPrice = totalPrice;
        this.totalPriceWithDiscount = totalPriceWithDiscount;
        this.items = items;
    }

    public static class BasketItem {
        private String name;
        private double cost;
        private double discount;
        private double finalPrice;

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

    public List<Basket.BasketItem> getItems() {
        return items;
    }

    public void setItems(List<Basket.BasketItem> items) {
        this.items = items;
    }
}
