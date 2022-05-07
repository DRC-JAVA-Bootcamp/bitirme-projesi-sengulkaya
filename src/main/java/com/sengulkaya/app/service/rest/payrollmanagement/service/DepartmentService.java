package com.sengulkaya.app.service.rest.payrollmanagement.service;

import com.sengulkaya.app.service.rest.payrollmanagement.data.dal.ServiceDAL;
import com.sengulkaya.app.service.rest.payrollmanagement.dto.requestDTO.DepartmentRequestDTO;
import com.sengulkaya.app.service.rest.payrollmanagement.dto.requestDTO.ManagerRequestDTO;
import com.sengulkaya.app.service.rest.payrollmanagement.dto.responseDTO.DepartmentResponseDTO;
import com.sengulkaya.app.service.rest.payrollmanagement.dto.responseDTO.ManagerResponseDTO;
import com.sengulkaya.app.service.rest.payrollmanagement.mapper.IDepartmantMapper;
import com.sengulkaya.app.service.rest.payrollmanagement.mapper.IManagerMapper;

import java.util.List;

public class DepartmentService {
    private final ServiceDAL serviceDAL;
    private final IDepartmantMapper departmantMapper;

    public DepartmentService(ServiceDAL serviceDAL,
                             IDepartmantMapper departmantMapper)
    {
        this.serviceDAL = serviceDAL;
        this.departmantMapper = departmantMapper;
    }

    public DepartmentResponseDTO saveDepartment(DepartmentRequestDTO departmentRequestDTO)
    {
        return departmantMapper.toDepartmentResponseDTO
                (serviceDAL.saveDepartment(departmantMapper.toDepartment(departmentRequestDTO)));
    }

    public DepartmentResponseDTO updateDepartment(DepartmentRequestDTO departmentRequestDTO)
    {
        //
    }

    public DepartmentResponseDTO removeDepartmentById(Long departmentId)
    {

    }

    public List<DepartmentResponseDTO> findAllDepartmetns()
    {

    }

}
