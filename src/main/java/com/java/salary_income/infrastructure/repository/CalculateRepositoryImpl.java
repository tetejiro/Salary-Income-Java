package com.java.salary_income.infrastructure.repository;

import com.java.salary_income.domain.entity.SalaryInfoEntity;
import com.java.salary_income.domain.repository.CalculateRepository;
//import com.java.salary_income.infrastructure.mapper.CalculateMapper;
import org.springframework.stereotype.Repository;

@Repository
public class CalculateRepositoryImpl implements CalculateRepository {

//    private CalculateMapper calculateMapper;
    private SalaryInfoEntity salaryInfoEntity;

    public CalculateRepositoryImpl(
//        CalculateMapper calculateMapper
        SalaryInfoEntity salaryInfoEntity
    ) {
//        this.calculateMapper = calculateMapper;
        this.salaryInfoEntity = salaryInfoEntity;
    }

    @Override
    public float getYearlySalary() {
        return 1;//calculateMapper.get();
    }

    @Override
    public void post(SalaryInfoEntity salaryInfoEntity) {
        // calculateMapper.get();
    }
}
