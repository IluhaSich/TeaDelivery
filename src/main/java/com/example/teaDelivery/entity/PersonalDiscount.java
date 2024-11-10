package com.example.teaDelivery.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "personal_discount")
public class PersonalDiscount extends BaseEntity {
    private String discountName;
    private String description;
    private String teaSort;
    private double discount;
    private boolean wasUsed;

    @Column(name = "discount_name")
    public String getDiscountName() {
        return discountName;
    }

    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    @Column(name = "tea_sort")
    public String getTeaSort() {
        return teaSort;
    }

    @Column(name = "discount")
    public double getDiscount() {
        return discount;
    }

    @Column(name = "was_used")
    public boolean isWasUsed() {
        return wasUsed;
    }

    public void setDiscountName(String discountName) {
        this.discountName = discountName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTeaSort(String teaSort) {
        this.teaSort = teaSort;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public void setWasUsed(boolean wasUsed) {
        this.wasUsed = wasUsed;
    }
}

