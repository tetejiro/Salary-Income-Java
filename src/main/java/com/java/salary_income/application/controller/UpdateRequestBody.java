package com.java.salary_income.application.controller;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class UpdateRequestBody {

    int userId;
    List<UpdateRequestBody.Content> requestBodies;

    @Data
    @Builder
    public class Content {
        public int month;
        public int amount;
    }
}
