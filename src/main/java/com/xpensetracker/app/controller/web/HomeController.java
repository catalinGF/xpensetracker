package com.xpensetracker.app.controller.web;

import com.xpensetracker.app.repository.ExpenseRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    private final ExpenseRepository expenseRepository;

    public HomeController(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    @RequestMapping("/")
    public String home() {
        return "index";
    }
}


