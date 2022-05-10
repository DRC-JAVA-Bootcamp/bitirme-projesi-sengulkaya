package com.sengulkaya.app.service.rest.payrollmanagement.service;

import com.sengulkaya.app.service.rest.payrollmanagement.data.dal.ServiceDAL;
import com.sengulkaya.app.service.rest.payrollmanagement.data.entity.employee.*;
import com.sengulkaya.app.service.rest.payrollmanagement.dto.requestDTO.SalesManagerRequestDTO;
import com.sengulkaya.app.service.rest.payrollmanagement.dto.responseDTO.SalesManagerResponseDTO;
import com.sengulkaya.app.service.rest.payrollmanagement.mapper.SalesManagerMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class SalesManagerService  {
    private final ServiceDAL serviceDAL;
    private final SalesManagerMapper salesManagerMapper;


    public SalesManagerService(ServiceDAL serviceDAL, SalesManagerMapper salesManagerMapper) {

        this.serviceDAL = serviceDAL;
        this.salesManagerMapper = salesManagerMapper;
    }

    @Transactional
    public SalesManagerResponseDTO saveSalesManager(SalesManagerRequestDTO salesManagerRequestDTO)
    {
        Department department = serviceDAL.findDepartmentById(salesManagerRequestDTO.getDepartmentId());
        SalesManager salesManager = serviceDAL.saveSalesManager(salesManagerMapper.toSalesManager(salesManagerRequestDTO));
        department.getEmployees().add(salesManager);//??
        salesManager.setDepartment(serviceDAL.saveDepartment(department));

        return salesManagerMapper.toSalesManagerResponseDTO(salesManager);

    }

    @Transactional
    public SalesManagerResponseDTO updateSalesManager(Long employeeId, SalesManagerRequestDTO salesManagerRequestDTO)
    {
        SalesManager found = serviceDAL.findSalesManagerByEmployeeId(employeeId);

        found.setCitizenId(salesManagerRequestDTO.getCitizenId());
        found.setName(salesManagerRequestDTO.getName());
        found.setDateOfBirth(salesManagerRequestDTO.getDateOfBirth());
        found.setDepartment(serviceDAL.findDepartmentById(salesManagerRequestDTO.getDepartmentId()));
        found.setJobTitle(salesManagerRequestDTO.getJobTitle());
        found.setDateOfEmployment(salesManagerRequestDTO.getDateOfEmployment());
        found.setBaseSalary(salesManagerRequestDTO.getBaseSalary());
        found.setRatePerHour(salesManagerRequestDTO.getRatePerHour());
        found.setActive(salesManagerRequestDTO.isActive());

        return salesManagerMapper.toSalesManagerResponseDTO(serviceDAL.saveSalesManager(found));
    }

    @Transactional
    public SalesManagerResponseDTO deleteSalesManagerByEmployeeId(Long employeeId)
    {
        SalesManager salesManager = serviceDAL.findSalesManagerByEmployeeId(employeeId);
        Department department = salesManager.getDepartment();

        Set<Employee> set = department.getEmployees();
        set.remove(salesManager);
        //salesManager.setEmployees(set);
        serviceDAL.saveDepartment(department);
        return salesManagerMapper.toSalesManagerResponseDTO
                (serviceDAL.removeSalesManager(salesManager));
    }


    public SalesManagerResponseDTO findSalesManagerByEmployeeId(Long employeeId)
    {
        return salesManagerMapper.toSalesManagerResponseDTO(serviceDAL.findSalesManagerByEmployeeId(employeeId));
    }

    public List<SalesManagerResponseDTO> findAllSalesManagers()
    {
        return serviceDAL.findAllSalesManagers().stream()
                .map(salesManagerMapper::toSalesManagerResponseDTO)
                .collect(Collectors.toList());

    }

}
