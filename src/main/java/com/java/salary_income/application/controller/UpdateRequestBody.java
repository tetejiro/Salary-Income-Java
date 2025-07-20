package com.java.salary_income.application.controller;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class UpdateRequestBody {

    int userId;
    List<Content> requestBodies;

    @Data
    public class Content {
        public int year;
        public int month;
        public int grossPay; // 総支給額（交通費は除く）
        public int deduction; // 控除額
    }
}
