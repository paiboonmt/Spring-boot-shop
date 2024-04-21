package com.shop.controller;

import com.shop.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class OrderDetailController {
    @Autowired
    private OrderDetailService orderDetailService;



}
