package com.java.salary_income.application.controller;

import com.java.salary_income.application.service.CalculateService;
import com.java.salary_income.domain.entity.SalaryInfoEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CalculateController{
    private final CalculateService calculateService;

    public CalculateController(CalculateService calculateService) {
        this.calculateService = calculateService;
    }

    // curl 'http://localhost:8080/year-income'
    @GetMapping({"/year-income", "/year-income/"})
    public int getIncome() {
        return calculateService.getYearlySalary();
    }

    @GetMapping({"/test/{month}"})
    public SalaryInfoEntity.SalaryInfo getTest(@PathVariable("month") int month) {
        return calculateService.getTest(month);
    };

    @GetMapping({"/year-net-income", "/year-net-income/"})
    public int getNetIncome() {
        return 1;
    }

    // curl.exe -X POST -H "Content-Type: application/json" -d '{salaryInfo: [{year: 2025, month:1, salary:269818}, {year: 2025, month:3, salary:279931}]}' localhost:8080/year-income
    @RequestMapping(value = {"/year-income", "/year-income/"}, method = RequestMethod.POST)
    public void post(@RequestBody PostRequestBody postRequestBody) {
        calculateService.post(postRequestBody);
    }

    @PostMapping("/update")
    public void update(@RequestBody UpdateRequestBody updateRequestBody) {

    }
}
