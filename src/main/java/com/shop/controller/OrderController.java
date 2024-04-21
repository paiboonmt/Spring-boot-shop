package com.shop.controller;

import com.shop.entity.Order;
import com.shop.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.Style;
import java.util.List;

@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/list")
    public String order(Model model) {
        List<Order> orders = orderService.findAll();

        System.out.println(orders);
        model.addAttribute("orders", orders);
        return "list";
    }


}
