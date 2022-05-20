package com.sengulkaya.app.service.rest.payrollmanagement.controller;

import com.sengulkaya.app.service.rest.payrollmanagement.data.entity.employee.contracts.ILifeInsurance;
import com.sengulkaya.app.service.rest.payrollmanagement.service.LifeInsurancePaymentCalculatorService;
import com.sengulkaya.app.service.rest.payrollmanagement.service.LifeInsurancePaymentCalculatorServiceExp;
import org.springframework.context.annotation.Scope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/lifeInsuranceExperimental")
@Scope("prototype")
public class LifeInsurancePaymentCalculatorExp {
    private final LifeInsurancePaymentCalculatorServiceExp paymentCalculatorExp;

    public LifeInsurancePaymentCalculatorExp(LifeInsurancePaymentCalculatorServiceExp lifeInsurancePaymentCalculatorExp)
    {
        this.paymentCalculatorExp = lifeInsurancePaymentCalculatorExp;
    }

    @GetMapping("/calculate/payments/exp")//Gives the answer 2x for the same employee!!!
    public ResponseEntity<String> payLifeInsurancePayments()
    {
        ResponseEntity<String> responseEntity = ResponseEntity.badRequest().build();

        try {
            responseEntity = ResponseEntity.ok(       paymentCalculatorExp.calculateAllInsurancePayments());

        } catch (Throwable ex) {
            System.out.printf("%s: %s", ex.getMessage(), ex.getCause());
        }
        return responseEntity;
    }
}
