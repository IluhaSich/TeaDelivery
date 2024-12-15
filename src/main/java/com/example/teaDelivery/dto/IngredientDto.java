package com.example.teaDelivery.dto;

public class IngredientDto extends BaseDto{
    private String ingredient_name;

    public IngredientDto(Long id,String ingredient_name) {
        setId(id);
        this.ingredient_name = ingredient_name;
    }

    public String getIngredient_name() {
        return ingredient_name;
    }

    public void setIngredient_name(String ingredient_name) {
        this.ingredient_name = ingredient_name;
    }
}
