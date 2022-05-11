package com.sengulkaya.app.service.rest.payrollmanagement.service;

import com.sengulkaya.app.service.rest.payrollmanagement.data.dal.ServiceDAL;
import com.sengulkaya.app.service.rest.payrollmanagement.data.entity.employee.Employee;
import com.sengulkaya.app.service.rest.payrollmanagement.data.entity.employee.contracts.HeavyConstructionInsurance;
import com.sengulkaya.app.service.rest.payrollmanagement.data.entity.employee.contracts.ILifeInsurance;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class LifeInsurancePaymentCalculatorService {
    private final ServiceDAL serviceDAL;

    public LifeInsurancePaymentCalculatorService(ServiceDAL serviceDAL)
    {
        this.serviceDAL = serviceDAL;
    }

    public List<Employee> findAllEmployees()
    {
        serviceDAL.findAllEmployees().stream()
                .forEach(e -> System.out.println(e.getClass()));

        return serviceDAL.findAllEmployees().stream()
                .filter(Employee::isActive)
                .filter(employee -> employee instanceof ILifeInsurance)//more meaningful when employees're under different kind of  contracts.
                .collect(Collectors.toList());


    }
}
