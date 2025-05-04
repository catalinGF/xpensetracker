package com.xpensetracker.app.controller.web;

import com.xpensetracker.app.model.UserDTO;
import com.xpensetracker.app.service.web.UserWebService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserWebController {

    private final UserWebService userWebService;


    public UserWebController(UserWebService userWebService) {
        this.userWebService = userWebService;
    }

    /*Bellow are the methods for interaction with Thymeleaf*/
    @GetMapping("/showusers")
    public String listUsers(Model model) {
        model.addAttribute("users", userWebService.getAllUsers());
        model.addAttribute("user", new UserDTO(null, "",""));
        return "showusers";
    }

    @PostMapping("/users/save")
    public String saveUser(@ModelAttribute("user") UserDTO userDTO) {
        userWebService.createUser(userDTO);
        return "redirect:/showusers";
    }

    @GetMapping("/users/delete/{id}")
    public String deleteUser(@PathVariable Long id) {
        userWebService.deleteUserById(id);
        return "redirect:/showusers";
    }
 }


