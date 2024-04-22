package com.shop.controller;

import com.shop.entity.OrderDetail;
import com.shop.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/orederlist")
public class OrderDetailController {
    @Autowired
    private OrderDetailService orderDetailService;

    public String printOrderDetail(OrderDetail orderDetail) {
        return "orderDetail";
    }



}
