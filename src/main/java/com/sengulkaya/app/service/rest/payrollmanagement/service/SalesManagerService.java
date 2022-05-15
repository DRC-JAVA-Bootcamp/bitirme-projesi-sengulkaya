package com.sengulkaya.app.service.rest.payrollmanagement.service;

import com.sengulkaya.app.service.rest.payrollmanagement.data.dal.ServiceDAL;
import com.sengulkaya.app.service.rest.payrollmanagement.data.entity.employee.*;
import com.sengulkaya.app.service.rest.payrollmanagement.dto.exception.repository.RepositoryException;
import com.sengulkaya.app.service.rest.payrollmanagement.dto.exception.service.SalesManagerServiceException;
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
        try {

            Department department = serviceDAL.findDepartmentById(salesManagerRequestDTO.getDepartmentId());
            SalesManager salesManager = serviceDAL.saveSalesManager(salesManagerMapper.toSalesManager(salesManagerRequestDTO));
            department.getEmployees().add(salesManager);//??
            salesManager.setDepartment(serviceDAL.saveDepartment(department));

            return salesManagerMapper.toSalesManagerResponseDTO(salesManager);

        } catch (RepositoryException ex) {

            System.out.printf("%s: %s", ex.getMessage(), ex.getCause());
            throw new SalesManagerServiceException("SalesManagerService.saveSalesManager", ex.getCause());

        } catch (Throwable ex) {

            throw new SalesManagerServiceException("SalesManagerService.saveSalesManager", ex);
        }
    }

    @Transactional
    public SalesManagerResponseDTO updateSalesManager(Long employeeId, SalesManagerRequestDTO salesManagerRequestDTO)
    {
        try {

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

        } catch (RepositoryException ex) {

            System.out.printf("%s: %s", ex.getMessage(), ex.getCause());
            throw new SalesManagerServiceException("SalesManagerService.updateSalesManager", ex.getCause());

        } catch (Throwable ex) {

            throw new SalesManagerServiceException("SalesManagerService.updateSalesManager", ex);
        }
    }

    @Transactional
    public SalesManagerResponseDTO deleteSalesManagerByEmployeeId(Long employeeId)
    {
        try {

            SalesManager salesManager = serviceDAL.findSalesManagerByEmployeeId(employeeId);
            Department department = salesManager.getDepartment();

            Set<Employee> set = department.getEmployees();
            set.remove(salesManager);
            serviceDAL.saveDepartment(department);
            return salesManagerMapper.toSalesManagerResponseDTO
                    (serviceDAL.removeSalesManager(salesManager));

        } catch (RepositoryException ex) {

            System.out.printf("%s: %s", ex.getMessage(), ex.getCause());
            throw new SalesManagerServiceException("SalesManagerService.deleteSalesManagerByEmployeeId", ex.getCause());

        } catch (Throwable ex) {

            throw new SalesManagerServiceException("SalesManagerService.deleteSalesManagerByEmployeeId", ex);
        }
    }


    public SalesManagerResponseDTO findSalesManagerByEmployeeId(Long employeeId)
    {
        try {

            return salesManagerMapper.toSalesManagerResponseDTO(serviceDAL.findSalesManagerByEmployeeId(employeeId));

        } catch (RepositoryException ex) {

            System.out.printf("%s: %s", ex.getMessage(), ex.getCause());
            throw new SalesManagerServiceException("SalesManagerService.findSalesManagerByEmployeeId", ex.getCause());

        } catch (Throwable ex) {

            throw new SalesManagerServiceException("SalesManagerService.findSalesManagerByEmployeeId", ex);
        }
    }

    public List<SalesManagerResponseDTO> findAllSalesManagers()
    {
        try {

            return serviceDAL.findAllSalesManagers().stream()
                    .map(salesManagerMapper::toSalesManagerResponseDTO)
                    .collect(Collectors.toList());

        } catch (RepositoryException ex) {

            System.out.printf("%s: %s", ex.getMessage(), ex.getCause());
            throw new SalesManagerServiceException("SalesManagerService.findAllSalesManagers", ex.getCause());

        } catch (Throwable ex) {

            throw new SalesManagerServiceException("SalesManagerService.findAllSalesManagers", ex);
        }
    }

}
