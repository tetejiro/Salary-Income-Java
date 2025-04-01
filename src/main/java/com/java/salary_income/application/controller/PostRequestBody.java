package com.java.salary_income.application.controller;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public record PostRequestBody(
        List<SalaryInfo> salaryInfo
) {
    public record SalaryInfo (
        @NotNull
        Integer year,
        @NotNull
        Integer month,
        @NotNull
        Integer salary,
        int cost
    ) {}
}
