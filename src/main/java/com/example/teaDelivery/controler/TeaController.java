package com.example.teaDelivery.controler;

import com.example.teaDelivery.dto.TeaDto;
import com.example.teaDelivery.entity.Tea;
import com.example.teaDelivery.service.TeaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/")
public class TeaController {
    @Autowired
    TeaService teaService;

    @GetMapping("/getAllTea")
    public List<TeaDto> getAllTea(){
        return teaService.getAllTea();
    }
    @GetMapping("/getTeaBySort")
    public List<TeaDto> getTeaBySort(@RequestParam(name = "sort") String sort){
        return teaService.getBySort(sort);
    }
}
