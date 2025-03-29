package com.java.salary_income.application.service;

import com.java.salary_income.application.controller.PostRequestBody;
import com.java.salary_income.domain.entity.SalaryEntityFactory;
import com.java.salary_income.domain.repository.CalculateRepository;
import org.springframework.stereotype.Service;

@Service
public class CalculateService {

    private final CalculateRepository calculateRepository;
    private final SalaryEntityFactory salaryEntityFactory;

    public CalculateService(
        CalculateRepository calculateRepository,
        SalaryEntityFactory salaryEntityFactory
    ) {
        this.calculateRepository = calculateRepository;
        this.salaryEntityFactory = salaryEntityFactory;
    }

    public float getYearlySalary() {
        return calculateRepository.getYearlySalary();
    }

    public void post(PostRequestBody postRequestBody) {
        calculateRepository.post(salaryEntityFactory.create(postRequestBody));
    }
}
