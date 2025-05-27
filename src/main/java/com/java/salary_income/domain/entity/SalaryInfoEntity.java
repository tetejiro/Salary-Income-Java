package com.java.salary_income.domain.entity;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data
public class SalaryInfoEntity(
    List<SalaryInfo> salaryInfo
) {
    public record SalaryInfo (
        int year,
        int month,
        int salary,
        int cost
    ) {}
}
