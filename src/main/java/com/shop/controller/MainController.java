package com.shop.controller;

import com.shop.entity.Cart;
import com.shop.entity.Order;
import com.shop.entity.Product;
import com.shop.service.CartService;
import com.shop.service.OrderService;
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

    @Autowired
    private CartService cartService;

    @Autowired
    private OrderService orderService;


    @GetMapping("/")
    public String login(){
        return "login";
    }

    @GetMapping("/home")
    public String home(Model model ){
        List<Product> product = service.allProduct();
        model.addAttribute("products" , product);
        List<Cart> cartList = cartService.findAll();
        model.addAttribute("cart", cartList);
        model.addAttribute("currentUrl", "/home");
        return "index";
    }

    @GetMapping("/report")
    public String report(Model model){
        model.addAttribute("currentUrl", "/report");
        return "report";
    }

    @GetMapping("/list")
    public String list(Model model) {
        List<Order> orderList = orderService.findAll();
        model.addAttribute("orderList" , orderList);
        model.addAttribute("currentUrl", "/list");
        return "list";

    }


    @GetMapping("/logout")
    public String logout(){
        return "login";
    }
}
