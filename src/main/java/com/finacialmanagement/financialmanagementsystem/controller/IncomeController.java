package com.finacialmanagement.financialmanagementsystem.controller;

import com.finacialmanagement.financialmanagementsystem.dto.IncomeDto;
import com.finacialmanagement.financialmanagementsystem.entity.Income;
import com.finacialmanagement.financialmanagementsystem.service.IncomeServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:5173")
@RequestMapping("users/{userId}/incomes")
public class IncomeController {

    @Autowired
    IncomeServiceI incomeService;

    @PostMapping("/add")
    public Income addIncome(@RequestBody IncomeDto income){

        return incomeService.addIncome(income);
    }

    @GetMapping("/allincome")
    public List<Income> getAllIncome(@PathVariable Integer userId){
        return incomeService.getAllIncome(userId);
    }

    @GetMapping("/currentbalance")
    public Float getTotalIncome(@PathVariable Integer userId){
        return incomeService.getTotalIncome(userId);
    }


}
