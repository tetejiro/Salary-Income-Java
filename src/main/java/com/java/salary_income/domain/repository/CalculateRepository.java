package com.java.salary_income.domain.repository;

import com.java.salary_income.domain.entity.SalaryInfoEntity;
import com.java.salary_income.domain.entity.UpdateEntity;

public interface CalculateRepository {

    SalaryInfoEntity.SalaryInfo getTest(int test);

    int getYearlySalary();

    void post(SalaryInfoEntity salaryInfoEntity);

    boolean update(UpdateEntity updateEntity);
}
