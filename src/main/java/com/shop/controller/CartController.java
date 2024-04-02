package com.shop.controller;

import com.shop.entity.Cart;
import com.shop.entity.Product;
import com.shop.service.CartService;
import com.shop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class CartController {

    @Autowired
    private ProductService service;

    @Autowired
    private CartService cartService;

    @PostMapping("/addtocart")
    public String addItemTocart(@RequestParam Integer product_id ,
                                @RequestParam int quantity ,
                                @RequestParam String product_name ,
                                @RequestParam double price ,
                                Model model )
    {
        System.out.println();

        cartService.addToItemCart( product_id , quantity , product_name , price);
        model.addAttribute("msg" , "เพื่มสินค้าสำเร็จ");
        return "redirect:/";
    }

    @GetMapping("/cart/{product_id}")
    public String addcart(@PathVariable int product_id , Model model ){
        Product product = service.getProductById(product_id);
        model.addAttribute("product" , product);
        return "cart";
    }

    
}
