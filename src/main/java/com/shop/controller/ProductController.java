package com.shop.controller;

import java.util.List;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.shop.entity.Product;
import com.shop.service.ProductService;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService service;

//    http://localhost:1010/product
    @GetMapping
    public String product( Model model){
        List<Product> products = service.allProduct();
        model.addAttribute("product" , products);
        model.addAttribute("currentUrl", "/product");
        return "product";
    }

    @GetMapping("/deleteproduct/{id}")
    public String deleteProduct(@PathVariable int id){
        service.deleteById(id);
        return "redirect:/product";
    }

    @PostMapping("/updateproduct")
    public String updateProduct(@ModelAttribute Product product , HttpSession session){
        service.addProduct(product);
        session.setAttribute("msg", "Update Product Successfully");
        return "redirect:/product";
    }

    @GetMapping("/editproduct/{id}")
    public String editProduct(@PathVariable int id , Model model){
        Product product = service.getProductById(id);
        model.addAttribute("product" , product);
//        System.out.println(product);
        return "editproduct";
    }

    @GetMapping("/addproduct")
    public String addProduct(Model model){
        model.addAttribute("currentUrl", "/product");
        return "addproduct";
    }


    @PostMapping("/addProduct")
    public String insertProduct(@ModelAttribute Product product) {
        service.addProduct(product);
        return "redirect:/product";
    }
}
