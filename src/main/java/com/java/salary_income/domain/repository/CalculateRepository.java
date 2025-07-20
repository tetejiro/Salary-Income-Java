package com.java.salary_income.domain.repository;

import com.java.salary_income.domain.entity.SalaryInfoEntity;
import com.java.salary_income.domain.entity.UpdateEntity;

import java.time.YearMonth;

public interface CalculateRepository {

    SalaryInfoEntity.Content getMonthSalary(YearMonth yearMonth);

    int getYearlySalary(int year);

    void post(SalaryInfoEntity salaryInfoEntity);

    boolean update(UpdateEntity updateEntity);
}
