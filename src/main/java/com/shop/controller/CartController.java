package com.shop.controller;

import com.shop.entity.Cart;
import com.shop.entity.Product;
import com.shop.service.CartService;
import com.shop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class CartController {

    @Autowired
    private ProductService service;

    private CartService cartService;

    @GetMapping("/cart/{product_id}")
    public String addcart(@PathVariable int product_id , Model model ){
        Product product = service.getProductById(product_id);
        model.addAttribute("product" , product);
        return "cart";
    }
    
}
