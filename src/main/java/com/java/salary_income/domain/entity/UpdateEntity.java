package com.java.salary_income.domain.entity;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class UpdateEntity {
    
    public int userId;
    public List<UpdateEntity.Content> requestBodies;

    @Data
    @Builder
    public class Content {
        public int month;
        public int amount;
    }
}
