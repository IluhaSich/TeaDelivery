package com.example.teaDelivery;

import com.example.teaDelivery.entity.*;
import com.example.teaDelivery.repository.SupplierRepository;
import com.example.teaDelivery.repository.TeaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MyCommandLineRunner implements CommandLineRunner {
    @Autowired
    private final TeaRepository teaRepository;
    @Autowired
    private final SupplierRepository supplierRepository;


    public MyCommandLineRunner(TeaRepository teaRepository, SupplierRepository supplierRepository) {
        this.teaRepository = teaRepository;
        this.supplierRepository = supplierRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Supplier supplier1 = new Supplier();
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
        for (int i = 0 ; i < 10;i++){
            Tea newTea = new Tea();
            newTea.setSort(i < 5 ?"black tea": "green tea");
            newTea.setName("Name:" + i);
            newTea.setImage(i+".webp");
            newTea.setCost(200 + i);
            newTea.setDescription("вкусный чай " + i);
            newTea.setSuppliers(supplier1);
            newTea.setAvailability(true);
            teaRepository.save(newTea);
        }



    }
}
