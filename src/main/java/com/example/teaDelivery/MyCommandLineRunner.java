package com.example.teaDelivery;

import com.example.teaDelivery.entity.*;
import com.example.teaDelivery.repository.IngredientRepository;
import com.example.teaDelivery.repository.SupplierRepository;
import com.example.teaDelivery.repository.TeaIngredientRepository;
import com.example.teaDelivery.repository.TeaRepository;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class MyCommandLineRunner implements CommandLineRunner {
    private final TeaRepository teaRepository;
    private final IngredientRepository ingredientRepository;
    private final TeaIngredientRepository teaIngredientRepository;
    private final SupplierRepository supplierRepository;


    public MyCommandLineRunner(TeaRepository teaRepository, IngredientRepository ingredientRepository, TeaIngredientRepository teaIngredientRepository, SupplierRepository supplierRepository) {
        this.teaRepository = teaRepository;
        this.ingredientRepository = ingredientRepository;
        this.teaIngredientRepository = teaIngredientRepository;
        this.supplierRepository = supplierRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        int teaQ = 100;
        int ingredientsQ = 5;

        Faker faker = new Faker();
        Random random = new Random();

        Supplier supplier1 = new Supplier();
        supplier1.setId(1L);
        supplier1.setSupplier_name("ООО \"Джей эф кей\"");
        supplier1.setEmail("ooogfk@gmail.com");
        supplierRepository.save(supplier1);

        Tea tea1 = new Tea();
        tea1.setSort("black tea");
        tea1.setName("Апельсиновое печенье");
        tea1.setImage("orange-cookie.webp");
        tea1.setCost(200);
        tea1.setDescription("вкусный чай");
        tea1.setSuppliers(supplier1);
        tea1.setAvailability(true);
        teaRepository.save(tea1);
        for (int i = 0; i < teaQ; i++) {
            Tea newTea = new Tea();
            newTea.setSort(i % 2 == 0 ? "black tea" : "green tea");
            newTea.setName(faker.gameOfThrones().character());
            newTea.setImage(i + ".webp");
            newTea.setCost(random.nextInt(150,200));
            newTea.setDescription(faker.gameOfThrones().quote());
            newTea.setSuppliers(supplier1);
            newTea.setAvailability(true);
            teaRepository.save(newTea);
            for (int j = 0; j < ingredientsQ;j++){
                Ingredient ingredient = new Ingredient();
                ingredient.setIngredient_name(faker.cat().breed());
                ingredientRepository.save(ingredient);
                TeaIngredient teaIngredient = new TeaIngredient();
                teaIngredient.setIngredientId(ingredient);
                teaIngredient.setTeaId(newTea);
                teaIngredientRepository.save(teaIngredient);
            }
        }



        System.out.println("start");
    }
}
