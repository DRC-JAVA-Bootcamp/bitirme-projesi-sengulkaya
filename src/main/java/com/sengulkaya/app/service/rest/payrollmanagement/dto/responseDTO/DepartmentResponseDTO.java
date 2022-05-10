package com.sengulkaya.app.service.rest.payrollmanagement.dto.responseDTO;

import com.sengulkaya.app.service.rest.payrollmanagement.data.entity.employee.Department;
import com.sengulkaya.app.service.rest.payrollmanagement.data.entity.employee.Employee;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class DepartmentResponseDTO {
    private long id;
    private String departmentName;
    private Map<String, Long> employeeNameIds;

    public long getId() {
        return id;
    }

    public DepartmentResponseDTO setId(long id) {
        this.id = id;
        return this;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public DepartmentResponseDTO setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
        return this;
    }


    public Map<String, Long> getEmployeeNameIds() {
        return employeeNameIds;
    }

    public DepartmentResponseDTO setEmployeeNameIds(Map<String, Long> employeeNameIds) {
        this.employeeNameIds = employeeNameIds;
        return this;
    }
}
