package com.java.salary_income.domain.factory;

import com.java.salary_income.application.controller.UpdateRequestBody;
import com.java.salary_income.domain.entity.UpdateEntity;

public class UpdateEntityFactory {

    public UpdateEntity create(UpdateRequestBody requestBody) {
        return UpdateEntity.builder()
                .userId(requestBody.getUserId())
                .requestBodies(requestBody.getRequestBodies())
                .build();
    }
}
