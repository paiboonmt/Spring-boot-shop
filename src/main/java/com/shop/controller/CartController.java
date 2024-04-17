package com.shop.controller;

import com.shop.entity.Cart;
import com.shop.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @GetMapping
    public String cart (Model model) {
        List<Cart> cartList = cartService.findAll();
        model.addAttribute("cartList", cartList);
        return "cart";
    }


    @GetMapping("/add")
    public String addcart(@ModelAttribute Cart cart){
        cartService.save(cart);
        return "redirect:/cart";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Cart cart){
        cartService.save(cart);
        return "redirect:/cart";
    }

    @GetMapping("/delete/{id}")
    public String delete(@ModelAttribute Cart cart){
        cartService.delete(cart);
        return "redirect:/cart";
    }
}
