package com.shop.controller;

import com.shop.entity.Order;
import com.shop.service.CartService;
import com.shop.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private CartService cartService;


    @PostMapping("/add")
    public String addOrder( @ModelAttribute Order order ) {

        System.out.println(order);

        orderService.save(order);

        cartService.deleteByUserrole(order.getUserId());

        return "redirect:/home";
    }


}
