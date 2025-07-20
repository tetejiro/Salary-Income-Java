package com.java.salary_income.application.controller;

import com.java.salary_income.application.service.CalculateService;
import com.java.salary_income.domain.entity.SalaryInfoEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.YearMonth;

@RestController
@RequiredArgsConstructor
public class CalculateController{
    private final CalculateService calculateService;

//    public CalculateController(CalculateService calculateService) {
//        this.calculateService = calculateService;
//    }

    // curl 'http://localhost:8080/get-year-income/2025'
    @GetMapping({"/get-year-income/{year}", "/get-year-income/{year}/"})
    public int getYearlySalary(@PathVariable int year) {
        return calculateService.getYearlySalary(year);
    }

    // curl 'http://localhost:8080/get-month-income/2025/6'
    @GetMapping({"/get-month-income/{year}/{month}"})
    public SalaryInfoEntity.Content getMonthSalary(
        @PathVariable("year") int year,
        @PathVariable("month") int month
    ) {
        return calculateService.getMonthSalary(YearMonth.of(year, month));
    }

    // curl.exe -X POST -H "Content-Type: application/json" -d '{salaryInfo: [{year: 2025, month:6, grossPay:286731,costs:22211,deduction:48137}, {year: 2025, month:3, grossPay:311560,deduction:45009}]}' localhost:8080/insert-income
    @RequestMapping(value = {"/insert-income", "/insert-income/"}, method = RequestMethod.POST)
    public void post(@RequestBody PostRequestBody postRequestBody) {
        calculateService.post(postRequestBody);
    }

    // これまだ試してない。
    @PostMapping(value = {"/update-income"})
    public void update(@RequestBody UpdateRequestBody updateRequestBody) {
        calculateService.update(updateRequestBody);
    }
}
