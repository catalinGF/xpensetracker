package com.xpensetracker.app.controller.web;

import com.xpensetracker.app.model.UserDTO;
import com.xpensetracker.app.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;

@Controller
public class UserWebController {

    private final UserService userService;


    public UserWebController(UserService userService) {
        this.userService = userService;
    }

    /*Bellow are the methods for interaction with Thymeleaf*/
    @RequestMapping("/showusers")
    public String listUsers(Model model) {
        List<UserDTO> users = userService.getAllUsers().stream().sorted(Comparator.comparing(UserDTO::id)).toList();
        model.addAttribute("users", users);
        model.addAttribute("user", new UserDTO(null, "","", false));
        return "showusers";
    }

    @RequestMapping("/users/save")
    public String saveUser(@ModelAttribute("user") UserDTO userDTO) {
        userService.createUser(userDTO);
        return "redirect:/showusers";
    }

    @RequestMapping("/users/delete/{id}")
    public String deleteUser(@PathVariable Long id) {
        userService.deleteUserById(id);
        return "redirect:/showusers";
    }
 }


