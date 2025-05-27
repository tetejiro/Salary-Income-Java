package com.java.salary_income.domain.factory;

import com.java.salary_income.application.controller.PostRequestBody;
import com.java.salary_income.domain.entity.SalaryInfoEntity;

import java.util.List;
import java.util.stream.Collectors;

public class SalaryEntityFactory {

    public SalaryInfoEntity create(PostRequestBody postRequestBody) {
        List<SalaryInfoEntity.SalaryInfo> salaryInfo = postRequestBody.salaryInfo().stream().map(it ->
            new SalaryInfoEntity.SalaryInfo(it.year(), it.month(), it.salary(), it.cost())
        ).collect(Collectors.toList());

        return new SalaryInfoEntity(salaryInfo);
    }
}
