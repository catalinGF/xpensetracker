package com.xpensetracker.app.controller.web;

import com.xpensetracker.app.model.ExpenseDTO;
import com.xpensetracker.app.service.web.ExpenseWebService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ExpenseWebController {

    private final ExpenseWebService expenseWebService;

    public ExpenseWebController(ExpenseWebService expenseWebService) {
        this.expenseWebService = expenseWebService;
    }

    /*Bellow are the methods for interaction with Thymeleaf*/
    @GetMapping("/showexpenses")
    public String listExpenses(Model model) {
        List<ExpenseDTO> expenses = expenseWebService.getAllExpenses();
        model.addAttribute("expenses", expenses);
        return "showexpenses";
    }

    @PostMapping("/expenses/save")
    public String saveExpense(@ModelAttribute("expense") ExpenseDTO expenseDTO) {
        expenseWebService.createExpense(expenseDTO);
        return "redirect:/showexpenses";
    }

 }


