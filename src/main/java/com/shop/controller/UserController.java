package com.shop.controller;

import com.shop.entity.User;
import com.shop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserRepository userRepo;

    @PostMapping("/loginQuery")
    public String login(@RequestParam("username")String username,
                        @RequestParam("password")String password,
                        Model model)
    {

        List<User> user = userRepo.findAll();

        System.out.println(user.size());

        System.out.println(user.get(0).getUserName());

        System.out.println(user.get(0).getPassword());

        System.out.println(user.get(0).getRole());

        if ( user.get(0).getUserName().equals(username) && user.get(0).getPassword().equals(password)){
            if ( user.get(0).getRole() == 1) {
                model.addAttribute("user", user.get(0));
                return "redirect:/home";
            }
        }else {
            model.addAttribute("user", user.get(0));
            return "redirect:/login";
        }
        return "redirect:/login";
    }

}
