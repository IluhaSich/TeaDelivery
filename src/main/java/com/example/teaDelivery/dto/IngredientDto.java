package com.example.teaDelivery.dto;

public class IngredientDto {
    private String ingredient_name;

    public IngredientDto(String ingredient_name) {
        this.ingredient_name = ingredient_name;
    }

    public String getIngredient_name() {
        return ingredient_name;
    }

    public void setIngredient_name(String ingredient_name) {
        this.ingredient_name = ingredient_name;
    }
}
