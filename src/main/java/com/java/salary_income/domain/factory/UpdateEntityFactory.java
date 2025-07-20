package com.java.salary_income.domain.factory;

import com.java.salary_income.application.controller.UpdateRequestBody;
import com.java.salary_income.domain.entity.UpdateEntity;

import java.util.ArrayList;
import java.util.List;

public class UpdateEntityFactory {

    public UpdateEntity create(UpdateRequestBody requestBody) {
        List<UpdateEntity.Content> contents = new ArrayList<>();
        requestBody.getRequestBodies().stream().forEach(it ->
                contents.add(
                        UpdateEntity.Content.builder()
                                .year(it.year)
                                .month(it.month)
                                .grossPay(it.grossPay)
                                .deduction(it.getDeduction())
                                .build()
                )
        );

        return UpdateEntity.builder()
                .requestBodies(contents)
                .build();
    }
}
