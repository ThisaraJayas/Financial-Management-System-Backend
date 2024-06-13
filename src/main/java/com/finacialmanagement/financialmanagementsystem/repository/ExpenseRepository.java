package com.finacialmanagement.financialmanagementsystem.repository;

import com.finacialmanagement.financialmanagementsystem.entity.Expenses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExpenseRepository extends JpaRepository<Expenses,Integer> {
    List<Expenses> findByUserId(Integer userId);

    @Query("SELECT SUM(e.amount) FROM Expenses e where e.userId=:userId")
    Float getTotalExpensesByUserId(@Param("userId") Integer userId);
}
