package com.sengulkaya.app.service.rest.payrollmanagement.data.dal;

import com.sengulkaya.app.service.rest.payrollmanagement.data.entity.employee.Employee;
import com.sengulkaya.app.service.rest.payrollmanagement.data.repository.IEmployeeRepository;
import org.springframework.stereotype.Component;

@Component
public class ServiceDAL {
    private final IEmployeeRepository employeeRepository;
    public ServiceDAL(IEmployeeRepository employeeRepository)
    {
        this.employeeRepository = employeeRepository;
    }

    public Employee saveEmployee(Employee employee)
    {
        return employeeRepository.save(employee);
    }

    public Iterable<Employee> findAllEmployees()
    {
        return employeeRepository.findAll();
    }
}
