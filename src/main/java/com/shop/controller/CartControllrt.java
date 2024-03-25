package com.shop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.shop.entity.Product;

@Controller
public class CartControllrt {

    @PostMapping("/addtocart")
    public String addCart( @ModelAttribute Product product  ){
        return "";
    }
}
