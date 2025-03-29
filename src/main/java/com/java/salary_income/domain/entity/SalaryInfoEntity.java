package com.java.salary_income.domain.entity;

import java.util.List;

public record SalaryInfoEntity(
    List<SalaryInfo> salaryInfo
) {
    public record SalaryInfo (
        int month,
        int salary
    ) {}
}
