package com.java.salary_income.infrastructure.repository;

import com.java.salary_income.domain.entity.SalaryInfoEntity;
import com.java.salary_income.domain.entity.UpdateEntity;
import com.java.salary_income.domain.repository.CalculateRepository;
import com.java.salary_income.infrastructure.mapper.CalculateMapper;
import org.springframework.stereotype.Repository;

import java.time.YearMonth;

@Repository
public class CalculateRepositoryImpl implements CalculateRepository {

    private final CalculateMapper calculateMapper;
    private final SalaryInfoEntity salaryInfoEntity;

    public CalculateRepositoryImpl(
        CalculateMapper calculateMapper,
        SalaryInfoEntity salaryInfoEntity
    ) {
        this.calculateMapper = calculateMapper;
        this.salaryInfoEntity = salaryInfoEntity;
    }

    @Override
    public int getYearlySalary(int year) {
        return calculateMapper.getYearSalary(year);
    }

    @Override
    public SalaryInfoEntity.Content getMonthSalary(YearMonth yearMonth) {
        return calculateMapper.getMonthSalary(yearMonth.getYear(), yearMonth.getMonthValue());
    }

    @Override
    public void post(SalaryInfoEntity salaryInfoEntity) {
         calculateMapper.post(salaryInfoEntity.getSalaryInfo());
    }

    @Override
    public boolean update(UpdateEntity updateEntity) {
        return updateEntity.getRequestBodies().stream().anyMatch(entity ->
            calculateMapper.update(
                    entity.getYear(), entity.getMonth(), entity.getGrossPay(), entity.getDeduction()
            ) > 0 // 0より大きければ成功とみなす
        );
    }
}
