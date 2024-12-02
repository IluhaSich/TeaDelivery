package com.example.teaDelivery.service;

import com.example.teaDelivery.dto.TeaDto;
import com.example.teaDelivery.entity.BaseEntity;
import com.example.teaDelivery.entity.Tea;
import com.example.teaDelivery.repository.IngredientRepository;
import com.example.teaDelivery.repository.TeaIngredientRepository;
import com.example.teaDelivery.repository.TeaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TeaService implements BaseService<TeaDto, Tea> {
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

    public List<TeaDto> getAllTea(String name, String sort, int startCost, int endCost) {
        List<Tea> teas = name != null
                ? teaRepository.findByNameContainingIgnoreCaseAndSortContainingIgnoreCaseAndCostGreaterThanAndCostLessThan(name,sort,startCost,endCost)
//                ? teaRepository.findByNameContainingIgnoreCaseAndSortContainingIgnoreCase(name,sort)
//                ? teaRepository.findByTitleContainingIgnoreCase(searchTerm, pageable) //TODO: Pageable?
                : teaRepository.findAll();
//                : teaRepository.findAll(pageable);
        return teas.stream().map(this::convertToDto).collect(Collectors.toList());
    }


    public List<TeaDto> getBySort(String sort) {
//        return teaRepository.getBySort(sort);
        return teaRepository.getBySort(sort).stream().map(this::convertToDto).collect(Collectors.toList());
    }

    public TeaDto getTeaById(Long id) {
        return convertToDto(teaRepository.getById(id).orElseThrow(() -> new RuntimeException("Чай не найден")));
    }

    public TeaDto getLastTea() {
        // TODO: Реализовать получение последнего заказанного чая из общего списка заказов
        System.out.println(teaRepository.findAll().getFirst().getName());
        return convertToDto(teaRepository.findAll().getFirst());
    }

    public List<String> getAllSorts() {
        return teaRepository.findAllDistinctSort();
    }

    @Override
    public TeaDto convertToDto(Tea tea) {
        TeaDto teaDto = new TeaDto();
        teaDto.setId(tea.getId());
        teaDto.setSort(tea.getSort());
        teaDto.setName(tea.getName());
        teaDto.setImage(tea.getImage());
        teaDto.setCost(tea.getCost());
        teaDto.setDescription(tea.getDescription());
        teaDto.setSuppliers(tea.getSuppliers().getId());
        teaDto.setAvailability(tea.isAvailability());
        return teaDto;
    }
}
