package com.java.salary_income.application.controller;

import com.java.salary_income.application.service.CalculateService;
import org.springframework.web.bind.annotation.*;

@RestController
public class CalculateController{
    private CalculateService calculateService;

    public CalculateController(CalculateService calculateService) {
        this.calculateService = calculateService;
    }

    @GetMapping({"/year-income", "/year-income/"})
    public float get() {
        return calculateService.getYearlySalary();
    }

    @RequestMapping(value = {"/year-income/", "/year-income/"}, method = RequestMethod.POST)
    public void post(@RequestBody PostRequestBody postRequestBody) {
        calculateService.post(postRequestBody);
    }
}
