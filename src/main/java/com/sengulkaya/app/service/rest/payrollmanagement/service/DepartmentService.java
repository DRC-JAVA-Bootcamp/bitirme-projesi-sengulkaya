package com.sengulkaya.app.service.rest.payrollmanagement.service;

import com.sengulkaya.app.service.rest.payrollmanagement.data.dal.ServiceDAL;
import com.sengulkaya.app.service.rest.payrollmanagement.data.entity.employee.*;
import com.sengulkaya.app.service.rest.payrollmanagement.dto.requestDTO.DepartmentRequestDTO;
import com.sengulkaya.app.service.rest.payrollmanagement.dto.responseDTO.DepartmentResponseDTO;
import com.sengulkaya.app.service.rest.payrollmanagement.mapper.DepartmentMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
@Service
public class DepartmentService {
    private final ServiceDAL serviceDAL;
    private final DepartmentMapper departmentMapper;

    public DepartmentService(ServiceDAL serviceDAL,
                             DepartmentMapper departmantMapper)
    {
        this.serviceDAL = serviceDAL;
        this.departmentMapper = departmantMapper;
    }

    @Transactional
    public DepartmentResponseDTO saveDepartment(DepartmentRequestDTO departmentRequestDTO)
    {
         Department department = serviceDAL.saveDepartment(departmentMapper.toDepartment(departmentRequestDTO));
        return departmentMapper.toDepartmentResponseDTO(department);
    }

    @Transactional
    public DepartmentResponseDTO updateDepartment(Long departmentId, DepartmentRequestDTO departmentRequestDTO)
    {
        Department found = serviceDAL.findDepartmentById(departmentId);
        found.setDepartmentName(departmentRequestDTO.getDepartmentName());

        return departmentMapper.toDepartmentResponseDTO
                (serviceDAL.saveDepartment(found));
    }

    public DepartmentResponseDTO findDepartmentById(Long departmentId)
    {
        return departmentMapper.toDepartmentResponseDTO(serviceDAL.findDepartmentById(departmentId));
    }

    @Transactional
    public List<DepartmentResponseDTO> findAllDepartments()
    {
        return serviceDAL.findAllDepartments().stream()
                .map(departmentMapper::toDepartmentResponseDTO)
                .collect(Collectors.toList());
    }

}
