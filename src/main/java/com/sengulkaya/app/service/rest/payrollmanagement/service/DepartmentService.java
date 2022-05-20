package com.sengulkaya.app.service.rest.payrollmanagement.service;

import com.sengulkaya.app.service.rest.payrollmanagement.data.dal.ServiceDAL;
import com.sengulkaya.app.service.rest.payrollmanagement.data.entity.employee.*;
import com.sengulkaya.app.service.rest.payrollmanagement.dto.exception.repository.RepositoryException;
import com.sengulkaya.app.service.rest.payrollmanagement.dto.exception.service.DepartmentServiceException;
import com.sengulkaya.app.service.rest.payrollmanagement.dto.requestDTO.DepartmentRequestDTO;
import com.sengulkaya.app.service.rest.payrollmanagement.dto.responseDTO.DepartmentResponseDTO;
import com.sengulkaya.app.service.rest.payrollmanagement.mapper.DepartmentMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
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
        try {
            Department department = serviceDAL.saveDepartment(departmentMapper.toDepartment(departmentRequestDTO));
            return departmentMapper.toDepartmentResponseDTO(department);
        } catch (RepositoryException ex) {
            System.out.printf("%s: %s", ex.getMessage(), ex.getCause());
            throw new DepartmentServiceException("DepartmentService.saveDepartment", ex.getCause());
        } catch (Throwable ex) {
            throw new DepartmentServiceException("DepartmentService.saveDepartment", ex);
        }
    }

    @Transactional
    public DepartmentResponseDTO updateDepartment(Long departmentId, DepartmentRequestDTO departmentRequestDTO)
    {
        try {
            Department found = serviceDAL.findDepartmentById(departmentId);
            found.setDepartmentName(departmentRequestDTO.getDepartmentName());

            return departmentMapper.toDepartmentResponseDTO
                    (serviceDAL.saveDepartment(found));
        } catch (RepositoryException ex) {
            System.out.printf("%s: %s", ex.getMessage(), ex.getCause());
            throw new DepartmentServiceException("DepartmentService.updateDepartment", ex.getCause());
        } catch (Throwable ex) {
            throw new DepartmentServiceException("DepartmentService.updateDepartment", ex);
        }
    }

    public DepartmentResponseDTO findDepartmentById(Long departmentId)
    {
        try {
            return departmentMapper.toDepartmentResponseDTO(serviceDAL.findDepartmentById(departmentId));
        } catch (RepositoryException ex) {
            System.out.printf("%s: %s", ex.getMessage(), ex.getCause());
            throw new DepartmentServiceException("DepartmentService.findDepartmentById", ex.getCause());
        } catch (Throwable ex) {
            throw new DepartmentServiceException("DepartmentService.findDepartmentById", ex);
        }
    }

    @Transactional
    public List<DepartmentResponseDTO> findAllDepartments()
    {
        try {
            return serviceDAL.findAllDepartments().stream()
                    .map(departmentMapper::toDepartmentResponseDTO)
                    .collect(Collectors.toList());
        } catch (RepositoryException ex) {
            System.out.printf("%s: %s", ex.getMessage(), ex.getCause());
            throw new DepartmentServiceException("DepartmentService.findAllDepartments", ex.getCause());
        } catch (Throwable ex) {
            throw new DepartmentServiceException("DepartmentService.findAllDepartments", ex);
        }
    }
}
