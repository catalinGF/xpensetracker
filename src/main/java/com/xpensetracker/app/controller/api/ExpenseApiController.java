package com.xpensetracker.app.controller.api;

import com.xpensetracker.app.model.ExpenseDTO;
import com.xpensetracker.app.service.api.ExpenseApiService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/expenses")
@Tag(name = "Expense", description = "Expense operations")
public class ExpenseApiController {

    private final ExpenseApiService expenseApiService;

    public ExpenseApiController(ExpenseApiService expenseApiService) {
        this.expenseApiService = expenseApiService;
    }

    /*C R U D*/

    /*Create*/
    @PostMapping
    @Operation(summary = "Create an expense in database")
    public void createExpense(@RequestBody ExpenseDTO expenseDTO) {
        expenseApiService.createExpense(expenseDTO);
    }
    /*READ*/
    @GetMapping("/{id}")
    @Operation(summary = "Get an expense from database by id")
    public ExpenseDTO getExpenseById(@PathVariable long id) {
        return expenseApiService.getExpenseById(id);
    }

    /*DELETE*/
    @DeleteMapping("/{id}")
    @Operation(summary = "Delete an expense from database")
    public void deleteExpenseById(@PathVariable long id) {
        expenseApiService.deleteExpenseById(id);
    }
    /*GET ALL*/
    @GetMapping
    @Operation(summary = "Get all expenses from database")
    public List<ExpenseDTO> getAllExpenses() {
      return expenseApiService.getAllExpenses();
    }

    /*UPDATE*/
    @PutMapping("/{id}")
    @Operation(summary = "Update an expense in database")
    public void updateExpense(@PathVariable long id, @RequestBody ExpenseDTO expenseDTO) {
        expenseApiService.updateExpense(id, expenseDTO);
    }
}
