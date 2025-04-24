package com.xpensetracker.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "index";  // thymeleaf caută index.html din folderul templates
    }

    @GetMapping("/showusers")
    public String user() {
        return "showusers";
    }

    @GetMapping("/showcategories")
    public String category() {
        return "showcategories";
    }
 }


