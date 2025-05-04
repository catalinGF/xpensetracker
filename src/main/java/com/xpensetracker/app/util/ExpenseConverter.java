package com.xpensetracker.app.util;

import com.xpensetracker.app.entity.Category;
import com.xpensetracker.app.entity.Expense;
import com.xpensetracker.app.model.ExpenseDTO;

import java.util.Optional;

public class ExpenseConverter {

    private ExpenseConverter() {

    }

    public static String convertAmount(Double amount) {
        return String.format("%.2f", amount);
    }

    public static String convertDate(java.util.Date date) {
        return date.toString();
    }

    public static java.util.Date convertStringToDate(String date) {
        return java.sql.Date.valueOf(date);
    }

    public static Double convertStringToAmount(String amount) {
        return Double.parseDouble(amount);
    }

    public static ExpenseDTO convertEntityToDTO(Expense expense) {
        Long categoryId = expense.getCategory() != null ? expense.getCategory().getId() : null;
        Long userId = expense.getUser() != null ? expense.getUser().getId() : null;
        return new ExpenseDTO(expense.getId(), expense.getDescription(), expense.getAmount(), expense.getDate(), categoryId, userId);
    }

    public static Expense convertDTOToEntity(ExpenseDTO expenseDTO){
        Expense expense = new Expense();
        expense.setAmount(expenseDTO.amount());
        expense.setDescription(expenseDTO.description());
        expense.setDate(expenseDTO.date());
        Optional.ofNullable(expenseDTO.categoryId()).ifPresent(categoryId -> {
            Category category = new Category();
            category.setId(categoryId);
            expense.setCategory(category);
        });
        Optional.ofNullable(expenseDTO.userId()).ifPresent(userId -> {
            com.xpensetracker.app.entity.User user = new com.xpensetracker.app.entity.User();
            user.setId(userId);
            expense.setUser(user);
        });
        return expense;
    }
}
