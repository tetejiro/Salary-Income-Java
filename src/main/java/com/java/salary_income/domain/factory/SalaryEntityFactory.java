package com.java.salary_income.domain.factory;

import com.java.salary_income.application.controller.PostRequestBody;
import com.java.salary_income.domain.entity.SalaryInfoEntity;

import java.util.List;
import java.util.stream.Collectors;

public class SalaryEntityFactory {

    public SalaryInfoEntity create(PostRequestBody postRequestBody) {
        List<SalaryInfoEntity.Content> salaryInfo = postRequestBody.salaryInfo().stream().map(it ->
            new SalaryInfoEntity.Content(it.year(), it.month(), it.grossPay(), it.deduction())
        ).collect(Collectors.toList());

        return SalaryInfoEntity.builder()
                .salaryInfo(salaryInfo)
                .build();
    }
}
