package com.java.salary_income.application.controller;

import java.util.List;

public record PostRequestBody(
        List<SalaryInfo> salaryInfo
) {
    public record SalaryInfo (
        int month,
        int salary
    ) {}
}
