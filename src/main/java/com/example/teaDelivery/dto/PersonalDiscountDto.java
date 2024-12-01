package com.example.teaDelivery.dto;

public class PersonalDiscountDto {
    private String discountName;
    private String description;
    private String teaSort;
    private double discount;
    private boolean wasUsed;

    public PersonalDiscountDto(String discountName, String description, String teaSort, double discount, boolean wasUsed) {
        this.discountName = discountName;
        this.description = description;
        this.teaSort = teaSort;
        this.discount = discount;
        this.wasUsed = wasUsed;
    }

    public PersonalDiscountDto() {

    }

    public String getDiscountName() {
        return discountName;
    }

    public void setDiscountName(String discountName) {
        this.discountName = discountName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTeaSort() {
        return teaSort;
    }

    public void setTeaSort(String teaSort) {
        this.teaSort = teaSort;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public boolean isWasUsed() {
        return wasUsed;
    }

    public void setWasUsed(boolean wasUsed) {
        this.wasUsed = wasUsed;
    }
}
