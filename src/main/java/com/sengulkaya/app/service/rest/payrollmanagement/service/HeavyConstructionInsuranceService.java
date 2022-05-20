package com.sengulkaya.app.service.rest.payrollmanagement.service;

import com.sengulkaya.app.service.rest.payrollmanagement.data.entity.employee.contracts.ILifeInsurance;
import com.sengulkaya.app.service.rest.payrollmanagement.dto.exception.service.LifeInsurancePaymentCalculatorServiceException;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class HeavyConstructionInsuranceService {
    private final Collection<HeavyConstructionInsuranceService> collection;

    public HeavyConstructionInsuranceService(Collection<HeavyConstructionInsuranceService> collection)
    {
        this.collection = collection;
    }

    public String calculateAllHeavyConstructionInsuranceServicePayments()
    {
        try {

            collection.stream()
                    .forEach(e -> System.out.println(e.getClass()));

            return "All Heavy Construction Insurance Service Payments are made";

        } catch (Throwable ex) {
            System.out.printf("%s: %s", ex.getMessage(), ex.getCause());
            throw new LifeInsurancePaymentCalculatorServiceException("HeavyConstructionInsuranceService.calculateAllHeavyConstructionInsuranceServicePayments", ex);
        }
    }
}
