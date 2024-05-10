package com.finacialmanagement.financialmanagementsystem.repository;

import com.finacialmanagement.financialmanagementsystem.entity.Income;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface IncomeRepository extends JpaRepository<Income,Integer> {
    List<Income> findByUserId(Integer userId);

    @Query("SELECT SUM(i.amount) FROM Income i WHERE i.userId=:userId")
    Float getTotalIncomeByUserId(@Param("userId") Integer userId);

    @Query("SELECT SUM(i.amount) FROM Income  i WHERE i.userId=:userId AND i.date BETWEEN :startDate AND :endDate")
    Float countIncomesByUserIdAndDateBetween(@Param("userId") Integer userId,@Param("startDate") Date startDate,@Param("endDate") Date endDate);
}
