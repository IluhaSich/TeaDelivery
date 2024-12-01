package com.example.teaDelivery.repository;

import com.example.teaDelivery.entity.Ingredient;
import com.example.teaDelivery.entity.Tea;
import com.example.teaDelivery.entity.TeaIngredient;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TeaIngredientRepository extends BaseRepository<TeaIngredient,Long>{
    // TODO: реализовать в сервисах
      List<TeaIngredient> getByTeaId(Tea teaId);
    //  List<Tea> getByIngredient(Ingredient ingredientId);
//    List<TeaIngredient> getByTeaId(Tea teaId);
//    List<TeaIngredient> getByIngredientId(Ingredient ingredientId);
}
