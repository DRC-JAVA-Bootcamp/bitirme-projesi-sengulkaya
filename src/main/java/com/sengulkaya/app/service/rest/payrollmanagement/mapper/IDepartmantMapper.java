package com.sengulkaya.app.service.rest.payrollmanagement.mapper;

import com.sengulkaya.app.service.rest.payrollmanagement.data.entity.employee.Department;
import com.sengulkaya.app.service.rest.payrollmanagement.dto.requestDTO.DepartmentRequestDTO;
import com.sengulkaya.app.service.rest.payrollmanagement.dto.responseDTO.DepartmentResponseDTO;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;

@Mapper(implementationName = "DepartmentMapperImpl", componentModel = "spring")
public interface IDepartmantMapper {

    Department toDepartment(DepartmentRequestDTO departmentRequestDTO);

    DepartmentResponseDTO toDepartmentResponseDTO(Department department);

}
