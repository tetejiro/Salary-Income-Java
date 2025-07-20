package com.java.salary_income.application.service;

import com.java.salary_income.application.controller.PostRequestBody;
import com.java.salary_income.application.controller.UpdateRequestBody;
import com.java.salary_income.domain.factory.SalaryEntityFactory;
import com.java.salary_income.domain.entity.SalaryInfoEntity;
import com.java.salary_income.domain.factory.UpdateEntityFactory;
import com.java.salary_income.domain.repository.CalculateRepository;
import org.springframework.stereotype.Service;

import java.time.YearMonth;

@Service
public class CalculateService {

    private final CalculateRepository calculateRepository;

    public CalculateService(
        CalculateRepository calculateRepository
    ) {
        this.calculateRepository = calculateRepository;
    }

    public int getYearlySalary(int year) {
        return calculateRepository.getYearlySalary(year);
    }

    public SalaryInfoEntity.Content getMonthSalary(YearMonth yearMonth) {
        return calculateRepository.getMonthSalary(yearMonth);
    }

    public void post(PostRequestBody postRequestBody) {
        calculateRepository.post(new SalaryEntityFactory().create(postRequestBody));
    }

    public void update(UpdateRequestBody updateRequestBody) {
        if (calculateRepository.update(new UpdateEntityFactory().create(updateRequestBody))) {
            throw new RuntimeException("AAAAAAAAAAAA");
        };
    }
}
