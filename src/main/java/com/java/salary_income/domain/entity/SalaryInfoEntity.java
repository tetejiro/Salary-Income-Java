package com.java.salary_income.domain.entity;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public record SalaryInfoEntity(
    List<SalaryInfo> salaryInfo
) {
    public record SalaryInfo (
        int year,
        int month,
        int salary,
        int cost
    ) {}
}
