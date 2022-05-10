package com.sengulkaya.app.service.rest.payrollmanagement.mapper;

import com.sengulkaya.app.service.rest.payrollmanagement.data.entity.employee.Department;
import com.sengulkaya.app.service.rest.payrollmanagement.data.entity.employee.Employee;
import com.sengulkaya.app.service.rest.payrollmanagement.dto.requestDTO.DepartmentRequestDTO;
import com.sengulkaya.app.service.rest.payrollmanagement.dto.responseDTO.DepartmentResponseDTO;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Component
public class DepartmentMapper {
    public Department toDepartment(DepartmentRequestDTO departmentRequestDTO) {
        if ( departmentRequestDTO == null ) {
            return null;
        }

        Department department = new Department();

        department.setDepartmentName(departmentRequestDTO.getDepartmentName());

        return department;
    }

    public DepartmentResponseDTO toDepartmentResponseDTO(Department department) {
        if ( department == null ) {
            return null;
        }

        DepartmentResponseDTO departmentResponseDTO = new DepartmentResponseDTO();

        departmentResponseDTO.setId(department.getDepartmentId())
                .setDepartmentName(department.getDepartmentName());
        Set<Employee> set = department.getEmployees();

        Map<String, Long> employeeNameIds = new HashMap<>();

        if ( set != null ) {
            for (var employee : set) {
                employeeNameIds.put(employee.getName(), employee.getEmployeeId());
            }
        }

        departmentResponseDTO.setEmployeeNameIds(employeeNameIds);

        return departmentResponseDTO;
    }

}
