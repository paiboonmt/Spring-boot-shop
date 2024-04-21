package com.shop.controller;

import com.shop.entity.Product;
import com.shop.service.ItemService;
import com.shop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ItemController {

    @Autowired
    ItemService itemService;

    @Autowired
    ProductService productService;

    @GetMapping("/addToCart/{id}")
    public String addToCart(@PathVariable int id) {
        boolean found = false;
        for (Product p : itemService.getItemList()) {
            if (p.getId() == id ) {
                p.setQuantity(p.getQuantity() + 1);
                p.setPrice(p.getPrice() * p.getQuantity());
                found = true;
                break;
            }
        }
        if (!found) {
            itemService.addItem(productService.getProductById(id));
        }
//
        return "redirect:/home";
    }

    @GetMapping("/clear/cart")
    public String clearCart() {
        itemService.clearItemList();
        return "redirect:/home";
    }


}
