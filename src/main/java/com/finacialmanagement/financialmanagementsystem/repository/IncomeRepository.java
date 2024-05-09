package com.finacialmanagement.financialmanagementsystem.repository;

import com.finacialmanagement.financialmanagementsystem.entity.Income;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IncomeRepository extends JpaRepository<Income,Integer> {
    List<Income> findByUserId(Integer userId);
}
