package com.xpensetracker.app.service;

import com.xpensetracker.app.model.ExpenseDTO;

import java.util.List;

public interface ExpenseService {

    ExpenseDTO getExpenseById(Long id);

    ExpenseDTO createExpense(ExpenseDTO expenseDTO);

    ExpenseDTO updateExpense(Long id, ExpenseDTO expenseDTO);

    void deleteExpenseById(Long id);

    List<ExpenseDTO> getAllExpenses();
}
