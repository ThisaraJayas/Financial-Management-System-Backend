package com.finacialmanagement.financialmanagementsystem.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String username;
    private String email;
    private String password;

//    @OneToMany(targetEntity = Income.class, cascade = CascadeType.ALL)
//    @JoinColumn(name = "ui_fk", referencedColumnName = "incomeId")
//    private List<Income> income;


}
