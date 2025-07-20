package com.java.salary_income.domain.entity;

import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@Builder
@Component
public class SalaryInfoEntity {
    List<Content> salaryInfo;

    public record Content (
        int year,
        int month,
        int grossPay,
        int deduction
    ) {}
}
