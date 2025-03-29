package com.java.salary_income.domain.repository;

import com.java.salary_income.domain.entity.SalaryInfoEntity;

public interface CalculateRepository {

    float getYearlySalary();

    void post(SalaryInfoEntity salaryInfoEntity);
}
