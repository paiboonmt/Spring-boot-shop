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
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CartController {

    @Autowired
    private ProductService service;

    @Autowired
    private CartService cartService;



    @PostMapping("/addtocart")
    public String addToCart(@ModelAttribute Cart cart ){
        System.out.println(cart);
        cartService.addCart(cart);
        return "redirect:/";
    }

    @GetMapping("/cart/{product_id}")
    public String addcart(@PathVariable int product_id , Model model ){
        Product product = service.getProductById(product_id);
        model.addAttribute("product" , product);
        return "cart";
    }

    
}
