package com.java.salary_income.application.controller;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public record PostRequestBody(
        List<Content> salaryInfo
) {
    public record Content (
        @NotNull
        int year,
        @NotNull
        int month,
        @NotNull
        int grossPay, // 総支給額
        int deduction // 控除額
    ) {}
}
