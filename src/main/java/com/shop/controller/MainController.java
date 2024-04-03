package com.shop.controller;

import com.shop.entity.Cart;
import com.shop.entity.Product;
import com.shop.service.CartService;
import com.shop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;


@Controller
public class MainController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CartService cartService;

    @GetMapping("/")
    public String home( Model model ) {
//        List<Product> products = productService.allProduct();
//        model.addAttribute("product" , products);
//        List<Cart> carts = cartService.carts();
//        model.addAttribute("cart" , carts );
        return  "index";
    }

}
