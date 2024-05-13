package com.finacialmanagement.financialmanagementsystem.repository;

import com.finacialmanagement.financialmanagementsystem.entity.Expenses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExpenseRepository extends JpaRepository<Expenses,Integer> {
    List<Expenses> findByUserId(Integer userId);
}
