package com.xpensetracker.app.controller.web;

import com.xpensetracker.app.entity.Expense;
import com.xpensetracker.app.model.ExpenseDTO;
import com.xpensetracker.app.service.CategoryService;
import com.xpensetracker.app.service.ExpenseService;
import com.xpensetracker.app.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Comparator;
import java.util.List;

@Controller
public class ExpenseWebController {

    private final ExpenseService expenseService;
    private final UserService userService;
    private final CategoryService categoryService;

    public ExpenseWebController(ExpenseService expenseService, UserService userService, CategoryService categoryService) {
        this.expenseService = expenseService;
        this.userService = userService;
        this.categoryService = categoryService;
    }

    /*Bellow are the methods for interaction with Thymeleaf*/
    @RequestMapping("/showexpenses")
    public String listExpenses(Model model) {
        List<ExpenseDTO> expenses = expenseService.getAllExpenses().stream()
                .sorted(Comparator.comparing(ExpenseDTO::id)).toList();
        model.addAttribute("expenses", expenses);
        model.addAttribute("expense", new ExpenseDTO(null, null, 0.00, null, null, null));
        model.addAttribute("categories", categoryService.getAllCategories());
        model.addAttribute("users", userService.getAllUsers());
        return "showexpenses";
    }

    @RequestMapping("/expenses/save")
    public String saveExpense(@ModelAttribute("expense") ExpenseDTO expenseDTO) {
        expenseService.createExpense(expenseDTO);
        return "redirect:/showexpenses";
    }

    @RequestMapping("/expenses/delete/{id}")
        public String deleteExpense(@PathVariable Long id) {
        expenseService.deleteExpenseById(id);
        return "redirect:/showexpenses";
    }

}


