package com.sengulkaya.app.service.rest.payrollmanagement.mapper;

import com.sengulkaya.app.service.rest.payrollmanagement.data.entity.employee.Department;
import com.sengulkaya.app.service.rest.payrollmanagement.data.entity.employee.Employee;
import com.sengulkaya.app.service.rest.payrollmanagement.dto.requestDTO.DepartmentRequestDTO;
import com.sengulkaya.app.service.rest.payrollmanagement.dto.responseDTO.DepartmentResponseDTO;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class DepartmentMapper {
    public Department toDepartment(DepartmentRequestDTO departmentRequestDTO) {
        if ( departmentRequestDTO == null ) {
            return null;
        }

        Department department = new Department();

        department.setDepartmentName( departmentRequestDTO.getDepartmentName() );

        return department;
    }

    public DepartmentResponseDTO toDepartmentResponseDTO(Department department) {
        if ( department == null ) {
            return null;
        }

        DepartmentResponseDTO departmentResponseDTO = new DepartmentResponseDTO();

        departmentResponseDTO.setId( department.getId() );
        departmentResponseDTO.setDepartmentName( department.getDepartmentName() );
        Set<Employee> set = department.getEmployees();
        if ( set != null ) {
            departmentResponseDTO.setEmployees( new HashSet<Employee>( set ) );
        }

        return departmentResponseDTO;
    }

}
