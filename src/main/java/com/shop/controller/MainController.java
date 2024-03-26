package com.shop.controller;

import com.shop.entity.Product;
import com.shop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;


@Controller
public class MainController {

    @Autowired
    private ProductService p;

    @GetMapping("/")
    public String home( Model model) {
        List<Product> products = p.allProduct();
        model.addAttribute("product" , products);
        return  "index";
    }

}
