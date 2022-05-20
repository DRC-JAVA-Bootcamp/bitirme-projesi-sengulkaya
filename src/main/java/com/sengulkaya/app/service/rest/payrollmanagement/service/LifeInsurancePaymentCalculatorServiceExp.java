package com.sengulkaya.app.service.rest.payrollmanagement.service;

import com.sengulkaya.app.service.rest.payrollmanagement.data.dal.ServiceDAL;
import com.sengulkaya.app.service.rest.payrollmanagement.data.entity.employee.Employee;
import com.sengulkaya.app.service.rest.payrollmanagement.data.entity.employee.contracts.ILifeInsurance;
import com.sengulkaya.app.service.rest.payrollmanagement.dto.exception.repository.RepositoryException;
import com.sengulkaya.app.service.rest.payrollmanagement.dto.exception.service.LifeInsurancePaymentCalculatorServiceException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LifeInsurancePaymentCalculatorServiceExp {
    private final Collection<ILifeInsurance> collection;

    public LifeInsurancePaymentCalculatorServiceExp(Collection<ILifeInsurance> collection)
    {
        this.collection = collection;
    }

    public String calculateAllInsurancePayments()
    {
        try {

            collection.stream()
                    .map(ILifeInsurance::calculateInsurancePayment)
                    .forEach(e -> System.out.println(e.toString()));

            return "All insurance payments are made";

        } catch (Throwable ex) {
            System.out.printf("%s: %s", ex.getMessage(), ex.getCause());
            throw new LifeInsurancePaymentCalculatorServiceException("LifeInsurancePaymentCalculatorServiceExp.calculateAllInsurancePayments", ex);
        }
    }
}
