package com.finacialmanagement.financialmanagementsystem.service.impl;

import com.finacialmanagement.financialmanagementsystem.dto.IncomeDto;
import com.finacialmanagement.financialmanagementsystem.entity.Income;
import com.finacialmanagement.financialmanagementsystem.repository.IncomeRepository;
import com.finacialmanagement.financialmanagementsystem.service.IncomeServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IncomeService implements IncomeServiceI {

    @Autowired
    IncomeRepository incomeRepository;

    @Override
    public Income addIncome(IncomeDto income) {

        Income newIncome = new Income(
                income.getIncomeId(),
                income.getUserId(),
                income.getDate(),
                income.getAmount(),
                income.getIncomeCategory()
        );
        return incomeRepository.save(newIncome);
    }

    @Override
    public List<Income> getAllIncome(Integer userId) {
        return incomeRepository.findByUserId(userId);
    }

    @Override
    public Float getTotalIncome(Integer userId) {
        return incomeRepository.getTotalIncomeByUserId(userId);
    }
}
