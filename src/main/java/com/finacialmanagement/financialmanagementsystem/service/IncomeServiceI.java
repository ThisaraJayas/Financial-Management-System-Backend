package com.finacialmanagement.financialmanagementsystem.service;

import com.finacialmanagement.financialmanagementsystem.dto.IncomeDto;
import com.finacialmanagement.financialmanagementsystem.entity.Income;

public interface IncomeServiceI {
    Income addIncome(IncomeDto income);
}
