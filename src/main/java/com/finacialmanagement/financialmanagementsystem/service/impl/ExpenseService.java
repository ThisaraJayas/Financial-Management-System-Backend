package com.finacialmanagement.financialmanagementsystem.service.impl;

import com.finacialmanagement.financialmanagementsystem.dto.ExpenseDto;
import com.finacialmanagement.financialmanagementsystem.entity.Expenses;
import com.finacialmanagement.financialmanagementsystem.repository.ExpenseRepository;
import com.finacialmanagement.financialmanagementsystem.service.ExpenseServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExpenseService implements ExpenseServiceI {

    @Autowired
    ExpenseRepository expenseRepository;
    @Override
    public Expenses addNewExpense(ExpenseDto expense) {
        Expenses expenses = new Expenses(
                expense.getExpenseId(),
                expense.getUserId(),
                expense.getDate(),
                expense.getAmount(),
                expense.getExpenseCategory()
        );
        return expenseRepository.save(expenses);
    }
}
