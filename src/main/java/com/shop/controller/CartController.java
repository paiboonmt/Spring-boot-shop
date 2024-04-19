package com.shop.controller;

import com.shop.entity.Cart;
import com.shop.service.CartService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @Autowired
    private HttpSession session;

    @GetMapping
    public String cart (Model model) {
        List<Cart> cartList = cartService.findAll();
        model.addAttribute("cartList", cartList);
        return "index";
    }

    @PostMapping("/add")
    public String addcart(
            @RequestParam("productId") int productId,
            @RequestParam("productName") String productName,
            @RequestParam("quantity") int quantity,
            @RequestParam("price") Double price,
            @RequestParam("userrole") int userrole){

        Cart cart = new Cart();
        cart.setProductId(productId);
        cart.setProductName(productName);
        cart.setQuantity(quantity);
        Double totalPrice = price * quantity;
        cart.setPrice(totalPrice);
        cart.setUserrole(userrole);
        cartService.save(cart);
        return "redirect:/home";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Cart cart){
        cartService.save(cart);
        return "redirect:/cart";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id ){
        cartService.delete(id);
        return "redirect:/home";
    }

    @GetMapping("/cart")
    public String checkout(Model model){
        List<Cart> cartList = cartService.findAll();
        long micrometer = java.time.Instant.now().toEpochMilli();
        String codeNumber = String.valueOf(micrometer);
        model.addAttribute("cartList", cartList);
        model.addAttribute("codeNumber", codeNumber);
        return "cart";
    }


}
