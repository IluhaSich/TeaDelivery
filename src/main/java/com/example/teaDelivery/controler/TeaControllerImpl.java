package com.example.teaDelivery.controler;

import com.example.pr6c.controller.TeaController;
import com.example.pr6c.viewmodel.base.BaseViewModel;
import com.example.pr6c.viewmodel.tea.AllTeaViewModel;
import com.example.pr6c.viewmodel.tea.PersonalDiscountViewModel;
import com.example.pr6c.viewmodel.tea.TeaSearchForm;
import com.example.pr6c.viewmodel.tea.TeaViewModel;
import com.example.teaDelivery.dto.TeaDto;
import com.example.teaDelivery.service.IngredientService;
import com.example.teaDelivery.service.SupplierService;
import com.example.teaDelivery.service.TeaService;
import org.springframework.data.domain.Page;
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
//TODO: Несколько контроллеров
//TODO: Разбить вьюшки (BaseViewModel  как вариант запихнуть UserViewModel)

@Controller
@RequestMapping("/tea")
public class TeaControllerImpl implements TeaController {
    TeaService teaService;
    IngredientService ingredientService;
    SupplierService supplierService;

    List<PersonalDiscountViewModel> personalDiscountViewModels = new ArrayList<>(List.of());

    public TeaControllerImpl(TeaService teaService, IngredientService ingredientService, SupplierService supplierService) {
        this.teaService = teaService;
        this.ingredientService = ingredientService;
        this.supplierService = supplierService;
        //TODO: Убрать заглушку для List<PersonalDiscountViewModel>
        personalDiscountViewModels.add(new PersonalDiscountViewModel("Черная пятница", "black description", "black tea", 10, false));
        personalDiscountViewModels.add(new PersonalDiscountViewModel("Зеленая пятница", "green description", "green tea", 20, false));
    }

    @GetMapping("/")
    public String getAllTea(@ModelAttribute("form") TeaSearchForm form, Model model) {
        String name = form.name() != null ? form.name() : "";
        String sort = form.sort() != null ? form.sort() : "";
        Integer startCost = form.startCost() != null ? form.startCost() : 0;
        Integer endCost = form.endCost() != null ? form.endCost() : 9999;
        Integer page = form.page() != null ? form.page() : 1;
        Integer size = form.size() != null ? form.size() : 5;
        form = new TeaSearchForm(name, sort, startCost, endCost,page,size);

        Page<TeaDto> teasDto = teaService.getAllTea(name,sort,startCost,endCost,page,size);
        List<TeaViewModel> teas = teasDto.stream().map(q -> new TeaViewModel(
                new BaseViewModel("",""),
                q.getId(),
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
                new BaseViewModel("",""),
                teas,
                form,
                teasDto.getTotalPages()
        );
        model.addAttribute("model", allTeaViewModel);
        model.addAttribute("form", form);
        return "tea-list";
    }

    @Override
    @GetMapping("/{id}")
    public String getTea(Model model, @PathVariable Long id) {
        TeaDto tea = teaService.getTeaById(id);
        TeaViewModel teaViewModel = new TeaViewModel(
                new BaseViewModel("",""),
                tea.getId(),
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

    @GetMapping("/ing")
    public List<String> getIng() {
        return ingredientService.getIngredientsByTeaId(1L);

    }

}
