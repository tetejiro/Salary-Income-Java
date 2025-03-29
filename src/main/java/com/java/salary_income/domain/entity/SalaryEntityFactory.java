package com.java.salary_income.domain.entity;

import com.java.salary_income.application.controller.PostRequestBody;

import java.util.ArrayList;
import java.util.List;

public class SalaryEntityFactory {

    public SalaryInfoEntity create(PostRequestBody postRequestBody) {
        List<SalaryInfoEntity.SalaryInfo> salaryInfo = new ArrayList();
        postRequestBody.salaryInfo().stream().map(it ->
            salaryInfo.add(new SalaryInfoEntity.SalaryInfo(it.month(), it.salary()))
        );
        return new SalaryInfoEntity(salaryInfo);
    }
}
