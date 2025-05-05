package com.xpensetracker.app.controller.web;

import com.xpensetracker.app.model.UserDTO;
import com.xpensetracker.app.service.web.UserWebService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Comparator;
import java.util.List;

@Controller
public class UserWebController {

    private final UserWebService userWebService;


    public UserWebController(UserWebService userWebService) {
        this.userWebService = userWebService;
    }

    /*Bellow are the methods for interaction with Thymeleaf*/
    @GetMapping("/showusers")
    public String listUsers(Model model) {
        List<UserDTO> users = userWebService.getAllUsers().stream().sorted(Comparator.comparing(UserDTO::id)).toList();
        model.addAttribute("users", users);
        model.addAttribute("user", new UserDTO(null, "","", false));
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


