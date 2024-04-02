package com.shop.controller;

import com.shop.entity.Cart;
import com.shop.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class OrderController {

//    @Autowired
//    private OrderService service;
//    @PostMapping("/confirmOrder")
//    public String Confirm(@ModelAttribute Order order){
//        return  null;
//    }

//    @GetMapping("/removeorder")
//    public String removeOrder(){
//        Cart Cart = null;
//        service.removeOrder(Cart);
//        return "refirect:/";
//    }


}
