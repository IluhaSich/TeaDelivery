package com.example.teaDelivery.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "tea_order")
public class TeaOrder extends BaseEntity {
    private Client client;
    private LocalDateTime time;
    private PersonalDiscount personalDiscount;
    private double cost;
    private LocalDateTime deliveryDate;
    private String deliveryCity;
    private String deliveryState;
    private String deliveryStreet;
    private String deliveryZip;
    private String orderStatus;

    @ManyToOne
    @JoinColumn(name = "client_id")
    public Client getClient() {
        return client;
    }


    @ManyToOne
    @JoinColumn(name = "discount_id")
    public PersonalDiscount getPersonalDiscount() {
        return personalDiscount;
    }
    @Column(name = "order_time")
    public LocalDateTime getTime() {
        return time;
    }

    @Column(name = "order_cost")
    public double getCost() {
        return cost;
    }

    @Column(name = "delivery_date")
    public LocalDateTime getDeliveryDate() {
        return deliveryDate;
    }

    @Column(name = "delivery_city")
    public String getDeliveryCity() {
        return deliveryCity;
    }

    @Column(name = "delivery_state")
    public String getDeliveryState() {
        return deliveryState;
    }

    @Column(name = "delivery_street")
    public String getDeliveryStreet() {
        return deliveryStreet;
    }

    @Column(name = "delivery_zip")
    public String getDeliveryZip() {
        return deliveryZip;
    }

    @Column(name = "delivery_status")
    public String getOrderStatus() {
        return orderStatus;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public void setPersonalDiscount(PersonalDiscount personalDiscount) {
        this.personalDiscount = personalDiscount;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public void setDeliveryDate(LocalDateTime deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public void setDeliveryCity(String deliveryCity) {
        this.deliveryCity = deliveryCity;
    }

    public void setDeliveryState(String deliveryState) {
        this.deliveryState = deliveryState;
    }

    public void setDeliveryStreet(String deliveryStreet) {
        this.deliveryStreet = deliveryStreet;
    }

    public void setDeliveryZip(String deliveryZip) {
        this.deliveryZip = deliveryZip;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }
}
