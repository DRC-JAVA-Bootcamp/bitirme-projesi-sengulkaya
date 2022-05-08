package com.sengulkaya.app.service.rest.payrollmanagement.dto.requestDTO;

import com.sengulkaya.app.service.rest.payrollmanagement.data.entity.employee.Employee;
import org.springframework.stereotype.Component;

import java.util.Set;


public class DepartmentRequestDTO {
    private String departmentName;


    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String depertmentName) {
        this.departmentName = departmentName;
    }

}
