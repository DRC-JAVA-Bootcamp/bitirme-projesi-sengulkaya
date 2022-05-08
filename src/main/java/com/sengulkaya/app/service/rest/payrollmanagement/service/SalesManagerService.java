package com.sengulkaya.app.service.rest.payrollmanagement.service;

import com.sengulkaya.app.service.rest.payrollmanagement.data.dal.ServiceDAL;
import com.sengulkaya.app.service.rest.payrollmanagement.data.entity.employee.*;
import com.sengulkaya.app.service.rest.payrollmanagement.dto.requestDTO.SalesManagerRequestDTO;
import com.sengulkaya.app.service.rest.payrollmanagement.dto.responseDTO.SalesManagerResponseDTO;
import com.sengulkaya.app.service.rest.payrollmanagement.mapper.SalesManagerMapper;
import org.springframework.stereotype.Service;

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

    public SalesManagerResponseDTO saveSalesManager(SalesManagerRequestDTO salesManagerRequestDTO)
    {
        return salesManagerMapper.toSalesManagerResponseDTO
                (serviceDAL.saveSalesManager(salesManagerMapper.toSalesManager(salesManagerRequestDTO)));

    }

    public SalesManagerResponseDTO updateSalesManager(SalesManagerRequestDTO salesManagerRequestDTO)
    {
        SalesManager found = serviceDAL.findSalesManagerById(salesManagerRequestDTO.getCitizenId());

        found.setName(salesManagerRequestDTO.getName());
        found.setDateOfBirth(salesManagerRequestDTO.getDateOfBirth());
        found.setDepartment(serviceDAL.findDepartmentByName(salesManagerRequestDTO.getDepartment()));
        found.setJobTitle(salesManagerRequestDTO.getJobTitle());
        found.setDateOfEmployment(salesManagerRequestDTO.getDateOfEmployment());
        found.setBaseSalary(salesManagerRequestDTO.getBaseSalary());
        found.setRatePerHour(salesManagerRequestDTO.getRatePerHour());
        found.setBonus(salesManagerRequestDTO.getBonus());
        found.setActive(salesManagerRequestDTO.isActive());

        return salesManagerMapper.toSalesManagerResponseDTO(serviceDAL.saveSalesManager(found));
    }

    public SalesManagerResponseDTO deleteSalesManagerById(String citizenId)
    {
        SalesManager salesManager = serviceDAL.findSalesManagerById(citizenId);
        Department department = salesManager.getDepartment();

        Set<Employee> set = department.getEmployees();
        set.remove(salesManager);
        //salesManager.setEmployees(set);
        serviceDAL.saveDepartment(department);
        return salesManagerMapper.toSalesManagerResponseDTO
                (serviceDAL.removeSalesManager(salesManager));
    }

    public SalesManagerResponseDTO findSalesManagerByCitizenId(String citizenId)
    {
        return salesManagerMapper.toSalesManagerResponseDTO(serviceDAL.findSalesManagerById(citizenId));
    }

    public List<SalesManagerResponseDTO> findAllSalesManagers()
    {
        return serviceDAL.findAllSalesManagers().stream()
                .map(salesManagerMapper::toSalesManagerResponseDTO)
                .collect(Collectors.toList());

    }

}
