package com.example.teaDelivery.controler;

import com.example.pr6c.controller.MainController;
import com.example.pr6c.viewmodel.*;
import com.example.teaDelivery.dto.ClientDto;
import com.example.teaDelivery.dto.PersonalDiscountDto;
import com.example.teaDelivery.dto.TeaDto;
import com.example.teaDelivery.service.IngredientService;
import com.example.teaDelivery.service.SupplierService;
import com.example.teaDelivery.service.TeaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class TeaController implements MainController {
    TeaService teaService;
    IngredientService ingredientService;
    SupplierService supplierService;

//    @Autowired // TODO: нужно ли?
    public TeaController(TeaService teaService, IngredientService ingredientService, SupplierService supplierService) {
        this.teaService = teaService;
        this.ingredientService = ingredientService;
        this.supplierService = supplierService;
    }

    @Override
    @GetMapping("/")
    public String GetMain(Model model) {
//        List<PersonalDiscountDto> personalDiscountDtos = new ArrayList<>(List.of());
//        personalDiscountDtos.add(new PersonalDiscountDto("Черная пятница","black description","black tea",10,false));
//        personalDiscountDtos.add(new PersonalDiscountDto("Зеленая пятница","green description","green tea",20,false));
//        MainViewModel viewModel = new MainViewModel(
//                new ClientDto(),
//                teaService.getLastTea(),
//                personalDiscountDtos,
//                teaService.getAllSorts()
//                ); //TODO: Сделать нормальное заполнение данных с нормальными запросами
//        model.addAttribute("model", viewModel);
        return "index";
//        List<PersonalDiscountDto> personalDiscountDtos = new ArrayList<>(List.of());
//        personalDiscountDtos.add(new PersonalDiscountDto("Черная пятница","black description","black tea",10,false));
//        personalDiscountDtos.add(new PersonalDiscountDto("Зеленая пятница","green description","green tea",20,false));
//        TeaDto tea = teaService.getLastTea();
//        MainViewModel viewModel = new MainViewModel(
//                new ClientViewModel(),
//                new TeaViewModel(
//                        new ClientViewModel(),
//                        tea.getImage(),
//                        tea.getName(),
//                        tea.getDescription(),
//                        tea.getSort(),
//                        ingredientService.getIngredientsByTeaId(tea.getId()),
//                        tea.getCost(),
//                        tea.isAvailability(),
//                        supplierService.getSupplierById(tea.getSuppliers()).getSupplier_name(),
//                        false),
//                null,
//                teaService.getAllSorts()
//        );
    }

    @GetMapping("/tea")
    public String getAllTea(Model model, TeaFilter filter) {
        List<TeaDto> teasDto = teaService.getAllTea();//TODO: .getAllTea(SearchTerm)
        List<TeaViewModel> teas = teasDto.stream().map(q -> new TeaViewModel(
                q.getId(),
                new ClientViewModel(),
                q.getImage(),
                q.getName(),
                q.getDescription(),
                q.getSort(),
                ingredientService.getIngredientsByTeaId(q.getId()),
                q.getCost(),
                q.isAvailability(),
                supplierService.getSupplierById(q.getSuppliers()).getSupplier_name(),
                false)).toList();
        AllTeaViewModel allTeaViewModel = new AllTeaViewModel(
                new ClientViewModel(),
                teas,
                filter,
                new PersonalDiscountViewModel()
        );
        model.addAttribute("model", allTeaViewModel);
        return "tea-list";
    }

    @Override
    @GetMapping("/tea/{id}")
    public String getTea(Model model, @PathVariable Long id) {
        TeaDto tea = teaService.getTeaById(id);
        TeaViewModel teaViewModel = new TeaViewModel(
                tea.getId(),
                new ClientViewModel(),
                tea.getImage(),
                tea.getName(),
                tea.getDescription(),
                tea.getSort(),
                ingredientService.getIngredientsByTeaId(tea.getId()),
                tea.getCost(),
                tea.isAvailability(),
                supplierService.getSupplierById(tea.getSuppliers()).getSupplier_name(),
                false);
        model.addAttribute("model", teaViewModel);
        return "tea";
    }

    @Override
    public void addTeaToBucket(Long id) {

    }

    @Override
    public void logout() {

    }
}
