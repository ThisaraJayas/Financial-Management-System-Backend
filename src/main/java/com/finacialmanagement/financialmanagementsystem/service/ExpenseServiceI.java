package com.finacialmanagement.financialmanagementsystem.service;

import com.finacialmanagement.financialmanagementsystem.dto.ExpenseDto;
import com.finacialmanagement.financialmanagementsystem.entity.Expenses;

import java.util.List;

public interface ExpenseServiceI {
    Expenses addNewExpense(ExpenseDto expense);

    List<Expenses> getAllExpenses(Integer userId);

    Float getTotalExpense(Integer userId);
}
