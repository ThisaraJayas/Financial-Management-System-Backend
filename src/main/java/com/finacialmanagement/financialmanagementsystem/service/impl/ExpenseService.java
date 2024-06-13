package com.finacialmanagement.financialmanagementsystem.service.impl;

import com.finacialmanagement.financialmanagementsystem.dto.ExpenseDto;
import com.finacialmanagement.financialmanagementsystem.entity.Expenses;
import com.finacialmanagement.financialmanagementsystem.repository.ExpenseRepository;
import com.finacialmanagement.financialmanagementsystem.service.ExpenseServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

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

    @Override
    public List<Expenses> getAllExpenses(Integer userId) {
        return expenseRepository.findByUserId(userId);
    }

    @Override
    public Float getTotalExpense(Integer userId) {
        return expenseRepository.getTotalExpensesByUserId(userId);
    }

    @Override
    public Float getMonthlyExpenses(Integer userId) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, -30);
        Date startDate = calendar.getTime();
        Date endDate = new Date();
        return expenseRepository.countExpenseByUserIdAndDateBetween(userId,startDate,endDate);
    }
}
