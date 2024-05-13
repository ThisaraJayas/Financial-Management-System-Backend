package com.finacialmanagement.financialmanagementsystem.service;

import com.finacialmanagement.financialmanagementsystem.dto.ExpenseDto;
import com.finacialmanagement.financialmanagementsystem.entity.Expenses;

public interface ExpenseServiceI {
    Expenses addNewExpense(ExpenseDto expense);
}
