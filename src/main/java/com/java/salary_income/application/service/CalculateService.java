package com.java.salary_income.application.service;

import com.java.salary_income.application.controller.PostRequestBody;
import com.java.salary_income.domain.entity.SalaryEntityFactory;
import com.java.salary_income.domain.repository.CalculateRepository;
import org.springframework.stereotype.Service;

@Service
public class CalculateService {

    private final CalculateRepository calculateRepository;

    public CalculateService(
        CalculateRepository calculateRepository
    ) {
        this.calculateRepository = calculateRepository;
    }

    public int getYearlySalary() {
        return calculateRepository.getYearlySalary();
    }

    public void post(PostRequestBody postRequestBody) {
        calculateRepository.post(new SalaryEntityFactory().create(postRequestBody));
    }
}
