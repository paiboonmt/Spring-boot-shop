package com.shop.controller;

import com.shop.entity.Promotion;
import com.shop.repository.PromotionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/promotion")
public class PromotionController {

    @Autowired
    private PromotionRepo repo;

    @GetMapping
    public String Promotion( Model model){
        model.addAttribute("currentUrl", "/promotion");
        List<Promotion> promotions = repo.findAll();
        model.addAttribute("promotions" , promotions);
        return "promotion";
    }

    @GetMapping("/addpromotion")
    public String AddPromotion( Model model){
        model.addAttribute("currentUrl", "/promotion");
        return "addpromotion";
    }

    @PostMapping("/addPromotion")
    public String addPromotion(@ModelAttribute Promotion promotion){
        System.out.println(promotion);
        repo.save(promotion);
        return "redirect:/promotion";
    }

    @GetMapping("/edit/{id}")
    public String getMethodName(@RequestParam int id) {
        return null;
    }

    @PostMapping("/updatepromotion")
    public String updatepromotion(@ModelAttribute Promotion promotion){
        repo.save(promotion);
        return "redirect:/promotion";
    }
}
