package com.finacialmanagement.financialmanagementsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class IncomeDto {
    private Integer incomeId;
    private Integer userId;
    private Date date;
    private float amount;
    private String incomeCategory;
}
