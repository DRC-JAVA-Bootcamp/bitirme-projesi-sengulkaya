package com.sengulkaya.app.service.rest.payrollmanagement.controller;

import com.sengulkaya.app.service.rest.payrollmanagement.data.entity.employee.Employee;
import com.sengulkaya.app.service.rest.payrollmanagement.data.entity.employee.contracts.ILifeInsurance;
import com.sengulkaya.app.service.rest.payrollmanagement.service.LifeInsurancePaymentCalculatorService;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/lifeInsurance")
@Scope("prototype")
public class LifeInsurancePaymentCalculator {
    private final LifeInsurancePaymentCalculatorService lifeInsurancePaymentCalculatorService;

    public LifeInsurancePaymentCalculator(LifeInsurancePaymentCalculatorService lifeInsurancePaymentCalculatorService)
    {
        this.lifeInsurancePaymentCalculatorService = lifeInsurancePaymentCalculatorService;
    }

    @GetMapping("/calculate/payments")//Gives the answer 2x for the same employee!!!
    public List<Double> calculateLifeInsurancePayments()
    {
        return lifeInsurancePaymentCalculatorService.findAllEmployees().stream()
                .mapToDouble(ILifeInsurance::calculateInsurancePayment)
                .boxed()
                .collect(Collectors.toList());
    }
}
