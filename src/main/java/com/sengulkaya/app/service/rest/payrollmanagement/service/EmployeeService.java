package com.sengulkaya.app.service.rest.payrollmanagement.service;

import com.sengulkaya.app.service.rest.payrollmanagement.data.dal.ServiceDAL;
import com.sengulkaya.app.service.rest.payrollmanagement.data.entity.employee.Employee;
import com.sengulkaya.app.service.rest.payrollmanagement.dto.requestDTO.EmployeeRequestDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class EmployeeService {
    private final ServiceDAL serviceDAL;


    public EmployeeService(ServiceDAL serviceDAL)
    {
        this.serviceDAL = serviceDAL;
    }

    public Employee saveEmployee(Employee employee)
    {
        return serviceDAL.saveEmployee(employee);
    }

    public List<Employee> findAllEmployees()
    {
        return StreamSupport.stream(serviceDAL.findAllEmployees().spliterator(), false)
                .collect(Collectors.toList());
    }
}
