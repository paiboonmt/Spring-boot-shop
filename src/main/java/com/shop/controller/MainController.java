package com.shop.controller;

import com.shop.entity.Order;
import com.shop.entity.Product;
import com.shop.service.ItemService;
import com.shop.service.OrderService;
import com.shop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MainController {

    @Autowired
    private ProductService service;

    @Autowired
    private OrderService orderService;

    @Autowired
    ItemService itemService;


    @GetMapping("/")
    public String login(){
        return "login";
    }

    @GetMapping("/home")
    public String home(Model model ){
        model.addAttribute("currentUrl", "/home");
        List<Product> product = service.allProduct();
        model.addAttribute("products" , product);
        model.addAttribute("cart" , itemService.getItemList());
        return "index";
    }

    @GetMapping("/report")
    public String report(Model model){
        model.addAttribute("currentUrl", "/report");
        return "report";
    }

//    @GetMapping("/list")
//    public String list(Model model) {
//        List<Order> orderList = orderService.findAll();
//        model.addAttribute("orderList" , orderList);
//        model.addAttribute("currentUrl", "/list");
//        return "list";
//
//    }

    @GetMapping("/logout")
    public String logout(){
        return "login";
    }


}
