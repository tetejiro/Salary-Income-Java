package com.java.salary_income.infrastructure.repository;

import com.java.salary_income.Calculate;
import com.java.salary_income.domain.entity.SalaryInfoEntity;
import com.java.salary_income.domain.entity.UpdateEntity;
import com.java.salary_income.domain.repository.CalculateRepository;
import com.java.salary_income.infrastructure.mapper.CalculateMapper;
import org.springframework.stereotype.Repository;

@Repository
public class CalculateRepositoryImpl implements CalculateRepository {

    private final CalculateMapper calculateMapper;
    private final SalaryInfoEntity salaryInfoEntity;
    private final Calculate calculate;

    public CalculateRepositoryImpl(
        CalculateMapper calculateMapper,
        Calculate calculate,
        SalaryInfoEntity salaryInfoEntity
    ) {
        this.calculateMapper = calculateMapper;
        this.calculate = calculate;
        this.salaryInfoEntity = salaryInfoEntity;
    }

    @Override
    public int getYearlySalary() {
        System.out.println(calculateMapper.get());
        return calculate.getYearlySalary(calculateMapper.get());
    }

    @Override
    public SalaryInfoEntity.SalaryInfo getTest(int month) {
        return calculateMapper.getTest(month);
    }

    @Override
    public void post(SalaryInfoEntity salaryInfoEntity) {
         calculateMapper.post(salaryInfoEntity.salaryInfo());
    }

    @Override
    public boolean update(UpdateEntity updateEntity) {
        return updateEntity.getRequestBodies().stream().anyMatch(entity ->
            calculateMapper.update(
                    entity.getMonth(), entity.getAmount(), updateEntity.getUserId()
            ) > 0
        );
    }
}
//        return updateEntity.getRequestBodies().stream().anyMatch(entity -> {
//            return calculateMapper.update(
//                    entity.getMonth(), entity.getAmount(), updateEntity.getUserId()
//            ) > 0;
//        });

//        updateEntity.getRequestBodies().stream().anyMatch(entity -> {
//            return calculateMapper.update(
//                    entity.getMonth(), entity.getAmount(), updateEntity.getUserId()
//            ) > 0
//        });