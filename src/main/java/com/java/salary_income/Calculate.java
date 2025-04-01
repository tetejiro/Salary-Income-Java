package com.java.salary_income;

import com.java.salary_income.domain.entity.SalaryInfoEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Calculate {

    private final SalaryInfoEntity salaryInfoEntity;

    public Calculate(SalaryInfoEntity salaryInfoEntity) {
        this.salaryInfoEntity = salaryInfoEntity;
    }

    public int getYearlySalary(List<SalaryInfoEntity.SalaryInfo> salaryInfo) {
        return salaryInfo.stream().mapToInt( it ->
                it.salary() - it.cost()
        ).sum();
    }
}
