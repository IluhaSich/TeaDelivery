package com.example.teaDelivery.controler;

import com.example.pr6c.controller.OrdersController;
import com.example.pr6c.viewmodel.OrdersFilter;
import org.springframework.ui.Model;


public class OrdersControllerImpl implements OrdersController {
    @Override
    public String getOrders(OrdersFilter filter, Model model) {
        return "";
    }
}
