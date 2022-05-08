package com.sengulkaya.app.service.rest.payrollmanagement.service;

import com.sengulkaya.app.service.rest.payrollmanagement.data.dal.ServiceDAL;
import com.sengulkaya.app.service.rest.payrollmanagement.data.entity.employee.Department;
import com.sengulkaya.app.service.rest.payrollmanagement.data.entity.employee.Employee;
import com.sengulkaya.app.service.rest.payrollmanagement.dto.requestDTO.DepartmentRequestDTO;
import com.sengulkaya.app.service.rest.payrollmanagement.dto.responseDTO.DepartmentResponseDTO;
import com.sengulkaya.app.service.rest.payrollmanagement.mapper.DepartmentMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
@Service
public class DepartmentService {
    private final ServiceDAL serviceDAL;
    private final DepartmentMapper departmantMapper;

    public DepartmentService(ServiceDAL serviceDAL,
                             DepartmentMapper departmantMapper)
    {
        this.serviceDAL = serviceDAL;
        this.departmantMapper = departmantMapper;
    }

    public DepartmentResponseDTO saveDepartment(DepartmentRequestDTO departmentRequestDTO)
    {
        return departmantMapper.toDepartmentResponseDTO
                (serviceDAL.saveDepartment(departmantMapper.toDepartment(departmentRequestDTO)));
    }

    public DepartmentResponseDTO updateDepartment(Long departmentId, DepartmentRequestDTO departmentRequestDTO)
    {
        Department found = serviceDAL.findDepartmentById(departmentId);
        found.setDepartmentName(departmentRequestDTO.getDepartmentName());

        return departmantMapper.toDepartmentResponseDTO
                (serviceDAL.saveDepartment(found));
    }

    public DepartmentResponseDTO removeDepartmentById(Long departmentId)
    {
        Department department = serviceDAL.findDepartmentById(departmentId);
        Set<Employee> employeeSet = department.getEmployees();
        for (var employee : employeeSet)
            employee.setDepartment(null);

        return departmantMapper.toDepartmentResponseDTO
                (serviceDAL.removeDepartment(department));
    }
    public DepartmentResponseDTO findDepartmentById(Long departmentId)
    {
        return departmantMapper.toDepartmentResponseDTO(serviceDAL.findDepartmentById(departmentId));
    }

    public List<DepartmentResponseDTO> findAllDepartmetns()
    {
        return serviceDAL.findAllDepartments().stream()
                .map(departmantMapper::toDepartmentResponseDTO)
                .collect(Collectors.toList());
    }

}
