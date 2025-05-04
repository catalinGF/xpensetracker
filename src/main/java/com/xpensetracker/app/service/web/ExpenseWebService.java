package com.xpensetracker.app.service.web;

import com.xpensetracker.app.model.ExpenseDTO;

import java.util.List;

public interface ExpenseWebService {

    ExpenseDTO getExpenseById(Long id);

    ExpenseDTO createExpense(ExpenseDTO expenseDTO);

    ExpenseDTO updateExpense(Long id, ExpenseDTO expenseDTO);

    void deleteExpenseById(Long id);

    List<ExpenseDTO> getAllExpenses();
}
