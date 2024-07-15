package com.finacialmanagement.financialmanagementsystem.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Data
public class Expenses {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer expenseId;
    private Integer userId;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT")
    private Date date;
    private float amount;
    private String expenseCategory;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;
}
