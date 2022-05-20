package com.sengulkaya.app.service.rest.payrollmanagement.controller;

import com.sengulkaya.app.service.rest.payrollmanagement.service.HeavyConstructionInsuranceService;
import com.sengulkaya.app.service.rest.payrollmanagement.service.LifeInsurancePaymentCalculatorServiceExp;
import org.springframework.context.annotation.Scope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/heavyConstructionInsuranceExperimental")
@Scope("prototype")
public class HeavyConstructionInsurancePaymentCalculatorExp {
    private final HeavyConstructionInsuranceService paymentCalculatorExp;

    public HeavyConstructionInsurancePaymentCalculatorExp(HeavyConstructionInsuranceService heavyConstructionInsuranceService)
    {
        this.paymentCalculatorExp = heavyConstructionInsuranceService;
    }

    @GetMapping("/calculate/payments/exp")//Gives the answer 2x for the same employee!!!
    public ResponseEntity<String> payLifeInsurancePayments()
    {
        ResponseEntity<String> responseEntity = ResponseEntity.badRequest().build();

        try {
            responseEntity = ResponseEntity.ok(       paymentCalculatorExp.calculateAllHeavyConstructionInsuranceServicePayments());

        } catch (Throwable ex) {
            System.out.printf("%s: %s", ex.getMessage(), ex.getCause());
        }
        return responseEntity;
    }
}
