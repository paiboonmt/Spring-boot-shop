package com.shop.controller;

import com.shop.entity.Cart;
import com.shop.entity.Order;
import com.shop.service.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class OrderController {

    private OrderService service;

    @PostMapping("/postaddtocart")
    public String addOrder(@ModelAttribute Order order){
        System.out.println(order);

        Double total = order.getTotal_price();
      System.out.println(total);
        return "redirect:/index";
    }
}
