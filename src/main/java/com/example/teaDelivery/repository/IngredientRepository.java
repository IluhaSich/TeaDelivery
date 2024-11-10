package com.example.teaDelivery.repository;

import com.example.teaDelivery.entity.Ingredient;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredientRepository extends BaseRepository<Ingredient,Long>{
//    Ingredient getByName(String name);
}
