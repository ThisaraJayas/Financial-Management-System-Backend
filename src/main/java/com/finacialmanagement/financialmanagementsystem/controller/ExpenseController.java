package com.finacialmanagement.financialmanagementsystem.controller;

import com.finacialmanagement.financialmanagementsystem.dto.ExpenseDto;
import com.finacialmanagement.financialmanagementsystem.entity.Expenses;
import com.finacialmanagement.financialmanagementsystem.service.ExpenseServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("http://localhost:5173")
@RequestMapping("users/{userId}/expenses")
public class ExpenseController {

    @Autowired
    ExpenseServiceI expenseService;
    @PostMapping("/add")
    public Expenses addExpense(@RequestBody ExpenseDto expense){
        return expenseService.addNewExpense(expense);
    }
}
