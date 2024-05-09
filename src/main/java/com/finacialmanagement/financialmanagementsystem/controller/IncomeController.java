package com.finacialmanagement.financialmanagementsystem.controller;

import com.finacialmanagement.financialmanagementsystem.dto.IncomeDto;
import com.finacialmanagement.financialmanagementsystem.entity.Income;
import com.finacialmanagement.financialmanagementsystem.service.IncomeServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("http://localhost:5173")
@RequestMapping("incomes")
public class IncomeController {

    @Autowired
    IncomeServiceI incomeService;

    @PostMapping("/add")
    public Income addIncome(@RequestBody IncomeDto income){
        return incomeService.addIncome(income);
    }
}
