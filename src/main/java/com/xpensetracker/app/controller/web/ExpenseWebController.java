package com.xpensetracker.app.controller.web;

import com.xpensetracker.app.model.ExpenseDTO;
import com.xpensetracker.app.service.ExpenseService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class ExpenseWebController {

    private final ExpenseService expenseService;

    public ExpenseWebController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    /*Bellow are the methods for interaction with Thymeleaf*/
    @RequestMapping("/showexpenses")
    public String listExpenses(Model model) {
        List<ExpenseDTO> expenses = expenseService.getAllExpenses();
        model.addAttribute("expenses", expenses);
        return "showexpenses";
    }

    @RequestMapping("/expenses/save")
    public String saveExpense(@ModelAttribute("expense") ExpenseDTO expenseDTO) {
        expenseService.createExpense(expenseDTO);
        return "redirect:/showexpenses";
    }

 }


