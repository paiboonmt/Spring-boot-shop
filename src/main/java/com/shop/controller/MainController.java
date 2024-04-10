package com.shop.controller;

import com.shop.entity.Product;
import com.shop.service.ProductService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MainController {

    @Autowired
    private ProductService service;

    @GetMapping("/")
    public String login(){
        return "login";
    }

    @GetMapping("/home")
    public String home(Model model , HttpSession session){
        session.removeAttribute("msg");

        List<Product> product = service.allProduct();
        model.addAttribute("products" , product);

        model.addAttribute("currentUrl", "/home");
        return "index";
    }

    @GetMapping("/report")
    public String report(Model model){
        model.addAttribute("currentUrl", "/report");
        return "report";
    }

    @GetMapping("/logout")
    public String logout(){
        return "login";
    }
}
