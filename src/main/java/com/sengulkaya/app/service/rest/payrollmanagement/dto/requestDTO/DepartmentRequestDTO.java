package com.sengulkaya.app.service.rest.payrollmanagement.dto.requestDTO;

import com.sengulkaya.app.service.rest.payrollmanagement.data.entity.employee.Employee;
import org.springframework.stereotype.Component;

import java.util.Set;


public class DepartmentRequestDTO {
    private String departmantName;
    private Set<Employee> employees;


    public String getDepartmantName() {
        return departmantName;
    }

    public void setDepartmantName(String departmantName) {
        this.departmantName = departmantName;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }
}
