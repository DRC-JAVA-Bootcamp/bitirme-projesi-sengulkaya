package com.sengulkaya.app.service.rest.payrollmanagement.controller;

import com.sengulkaya.app.service.rest.payrollmanagement.data.entity.employee.Employee;
import com.sengulkaya.app.service.rest.payrollmanagement.data.entity.employee.Manager;
import com.sengulkaya.app.service.rest.payrollmanagement.service.EmployeeService;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/employee")
@Scope("prototype")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService)
    {
        this.employeeService = employeeService;
    }

    @PostMapping("/save")
    public Employee saveEmployee(Manager manager)
    {
        throw new UnsupportedOperationException();//return employeeService.saveEmployee(new Manager().setCitizenId(manager.getCitizenId()));
    }

    @GetMapping("/find/all")
    public List<Employee> findAllEmployees()
    {
        return employeeService.findAllEmployees();
    }

}
