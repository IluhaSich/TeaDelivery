package com.example.teaDelivery.service;

import com.example.teaDelivery.dto.IngredientDto;
import com.example.teaDelivery.entity.Ingredient;
import com.example.teaDelivery.entity.TeaIngredient;
import com.example.teaDelivery.repository.IngredientRepository;
import com.example.teaDelivery.repository.TeaIngredientRepository;
import com.example.teaDelivery.repository.TeaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class IngredientService {
    TeaIngredientRepository teaIngredientRepository;
    TeaRepository teaRepository;
    IngredientRepository ingredientRepository;

    public IngredientService(TeaIngredientRepository teaIngredientRepository, TeaRepository teaRepository, IngredientRepository ingredientRepository) {
        this.teaIngredientRepository = teaIngredientRepository;
        this.teaRepository = teaRepository;
        this.ingredientRepository = ingredientRepository;
    }

    public List<String> getIngredientsByTeaId(Long id) {
        List<TeaIngredient> teaIngredients = teaIngredientRepository.getByTeaId(teaRepository.getById(id)
                .orElseThrow(() -> new RuntimeException("TeaIngredient не найден")));
        return teaIngredients.stream()
                .map(teaIngredient -> teaIngredient.getIngredientId().getIngredient_name())
                .collect(Collectors.toList());
    }

}
