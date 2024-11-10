package com.example.teaDelivery.service;

import com.example.teaDelivery.entity.Tea;
import com.example.teaDelivery.repository.IngredientRepository;
import com.example.teaDelivery.repository.TeaIngredientRepository;
import com.example.teaDelivery.repository.TeaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class TeaService {
    @Autowired
    private final TeaRepository teaRepository;
    @Autowired
    private final TeaIngredientRepository teaIngredientRepository;
    @Autowired
    private final IngredientRepository ingredientRepository;

    public TeaService(TeaRepository teaRepository, TeaIngredientRepository teaIngredientRepository, IngredientRepository ingredientRepository) {
        this.teaRepository = teaRepository;
        this.teaIngredientRepository = teaIngredientRepository;
        this.ingredientRepository = ingredientRepository;
    }

    //TODO: Return TeaDto
    public Set<Tea> getAllTea(){
        return teaRepository.getAll();
    }
}
