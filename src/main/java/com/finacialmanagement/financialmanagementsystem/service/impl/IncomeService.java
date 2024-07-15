package com.finacialmanagement.financialmanagementsystem.service.impl;

import com.finacialmanagement.financialmanagementsystem.dto.IncomeDto;
import com.finacialmanagement.financialmanagementsystem.entity.Income;
import com.finacialmanagement.financialmanagementsystem.repository.IncomeRepository;
import com.finacialmanagement.financialmanagementsystem.service.IncomeServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class IncomeService implements IncomeServiceI {

    private final IncomeRepository incomeRepository;

    @Autowired
    public IncomeService(IncomeRepository incomeRepository) {
        this.incomeRepository = incomeRepository;
    }

    @Override
    public Income addIncome(IncomeDto incomeDto) {
        Income newIncome = new Income();
        newIncome.setIncomeId(incomeDto.getIncomeId());
        newIncome.setUserId(incomeDto.getUserId());
        newIncome.setDate(incomeDto.getDate());
        newIncome.setAmount(incomeDto.getAmount());
        newIncome.setIncomeCategory(incomeDto.getIncomeCategory());

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

    @Override
    public Float getMonthlyIncome(Integer userId) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, -30);
        Date startDate = calendar.getTime();
        Date endDate = new Date();
        return incomeRepository.countIncomesByUserIdAndDateBetween(userId, startDate, endDate);
    }
}