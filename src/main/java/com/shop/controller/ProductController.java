package com.shop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.shop.entity.Product;
import com.shop.service.ProductService;

@Controller
public class ProductController {

    
    @Autowired
    private ProductService service;

    @GetMapping("/deleteproduct/{id}")
    public String deleteProduct(@PathVariable int id){
        service.deleteById(id);
        return "redirect:/product";
    }

    @PostMapping("/updateproduct")
    public String updateProduct(@ModelAttribute Product product){
        service.addProduct(product);
        return "redirect:/product";
    }

    @GetMapping("/editproduct/{id}")
    public String editProduct(@PathVariable int id , Model model){
        Product product = service.getProductById(id);
        model.addAttribute("product" , product);
//        System.out.println(product);
        return "editproduct";
    }

    @GetMapping("/product")
    public String product( Model model){
        List<Product> products = service.allProduct();
        model.addAttribute("product" , products);
        return "product";
    }
    @GetMapping("/addproduct")
    public String addProduct(){
        return "addproduct";
    }
    @PostMapping("/addProduct")
    public String insertProduct(@ModelAttribute Product product ) {
        service.addProduct(product);
        return "redirect:/product";
    }
}
