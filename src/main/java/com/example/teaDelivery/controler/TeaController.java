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

//TODO: Реализовать вход для пользователей (Админов?)
//TODO: Реализовать добавление в корзину товара (в Redis)
//TODO: Добавить пагинацию
//TODO: Заполнить все параметры в таблице значениями
//TODO: Убрать методы заглушки, заменив на нормальные
//TODO: ???

@Controller
@RequestMapping("/")
public class TeaController implements MainController {
    TeaService teaService;
    IngredientService ingredientService;
    SupplierService supplierService;

    List<PersonalDiscountViewModel> personalDiscountViewModels = new ArrayList<>(List.of());

    public TeaController(TeaService teaService, IngredientService ingredientService, SupplierService supplierService) {
        this.teaService = teaService;
        this.ingredientService = ingredientService;
        this.supplierService = supplierService;
        //TODO: Убрать заглушку для List<PersonalDiscountViewModel>
        personalDiscountViewModels.add(new PersonalDiscountViewModel("Черная пятница", "black description", "black tea", 10, false));
        personalDiscountViewModels.add(new PersonalDiscountViewModel("Зеленая пятница", "green description", "green tea", 20, false));
    }

    @Override
    @GetMapping("/")
    public String GetMain(Model model) {

        TeaDto teaDto = teaService.getLastTea();
        ClientViewModel clientViewModel = new ClientViewModel();
        TeaViewModel teaViewModel = new TeaViewModel(
                teaDto.getId(),
                clientViewModel,
                teaDto.getImage(),
                teaDto.getName(),
                teaDto.getDescription(),
                teaDto.getSort(),
                ingredientService.getIngredientsByTeaId(teaDto.getId()),
                teaDto.getCost(),
                teaDto.isAvailability(),
                supplierService.getSupplierById(teaDto.getSuppliers()).getSupplier_name(),
                false // TODO: has discount

        );
        MainViewModel viewModel = new MainViewModel(
                clientViewModel,
                teaViewModel,
                personalDiscountViewModels,
                teaService.getAllSorts()
        ); //TODO: Сделать нормальное заполнение данных с нормальными запросами
        model.addAttribute("model", viewModel);
        return "index";
    }

    @GetMapping("/tea")
    public String getAllTea(@ModelAttribute("form") TeaFilter form, Model model) {
        String name = form.name() != null ? form.name() : "";
        String sort = form.sort() != null ? form.sort() : "";
        Integer startCost = form.startCost() != null ? form.startCost() : 0;
        Integer endCost = form.endCost() != null ? form.endCost() : 9999;
        form = new TeaFilter(name, sort, startCost, endCost);


        List<TeaDto> teasDto = teaService.getAllTea(form.name(),form.sort(),form.startCost(),form.endCost());//TODO: .getAllTea(SearchTerm)
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
                false // TODO: has discount
        )).toList();
        AllTeaViewModel allTeaViewModel = new AllTeaViewModel(
                new ClientViewModel(),
                teas,
                form
        );
        model.addAttribute("model", allTeaViewModel);
        model.addAttribute("form", form);
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
                false // TODO: has discount
        );
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
