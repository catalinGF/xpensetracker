package com.xpensetracker.app.service.impl;

import com.xpensetracker.app.entity.Expense;
import com.xpensetracker.app.exception.ExpenseNotFoundException;
import com.xpensetracker.app.model.ExpenseDTO;
import com.xpensetracker.app.repository.ExpenseRepository;
import com.xpensetracker.app.service.ExpenseService;
import com.xpensetracker.app.util.ExpenseConverter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseServiceImpl implements ExpenseService {

    private final ExpenseRepository expenseRepository;
    public ExpenseServiceImpl(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    @Override
    public ExpenseDTO createExpense(ExpenseDTO expenseDTO) {
        Expense expense = ExpenseConverter.convertDTOToEntity(expenseDTO);
        Expense createdExpense = expenseRepository.save(expense);
        return ExpenseConverter.convertEntityToDTO(createdExpense);
    }

    @Override
    public ExpenseDTO getExpenseById(Long id) {
        Expense foundExpense = expenseRepository.findById(id).orElseThrow(() -> new ExpenseNotFoundException("Expense with id " + id + " not found"));
        return ExpenseConverter.convertEntityToDTO(foundExpense);
    }

    @Override
    public ExpenseDTO updateExpense(Long id, ExpenseDTO expenseDTO) {
        Expense expense = ExpenseConverter.convertDTOToEntity(expenseDTO);
        expense.setId(id);
        Expense updatedExpense = expenseRepository.save(expense);
        return ExpenseConverter.convertEntityToDTO(updatedExpense);
    }

    @Override
    public void deleteExpenseById(Long id) {
        expenseRepository.deleteById(id);
    }

    public List<ExpenseDTO> getAllExpenses() {
        List<Expense> allExpenses = expenseRepository.findAll();
        return allExpenses.stream().map(ExpenseConverter::convertEntityToDTO).toList();
    }

}
