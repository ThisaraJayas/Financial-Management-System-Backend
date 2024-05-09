package com.finacialmanagement.financialmanagementsystem.service;

import com.finacialmanagement.financialmanagementsystem.dto.IncomeDto;
import com.finacialmanagement.financialmanagementsystem.entity.Income;

import java.util.List;

public interface IncomeServiceI {
    Income addIncome(IncomeDto income);

    List<Income> getAllIncome(Integer userId);
}
