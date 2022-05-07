package com.sengulkaya.app.service.rest.payrollmanagement.dto.requestDTO;

import org.springframework.stereotype.Component;


public class DepartmentRequestDTO {
    private String departmantName;

    public String getName() {
        return departmantName;
    }

    public void setName(String name) {
        this.departmantName = name;
    }
}
