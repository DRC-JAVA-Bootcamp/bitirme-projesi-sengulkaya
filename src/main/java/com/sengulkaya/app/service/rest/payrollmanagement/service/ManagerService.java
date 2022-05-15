package com.sengulkaya.app.service.rest.payrollmanagement.service;

import com.sengulkaya.app.service.rest.payrollmanagement.data.dal.ServiceDAL;
import com.sengulkaya.app.service.rest.payrollmanagement.data.entity.employee.Department;
import com.sengulkaya.app.service.rest.payrollmanagement.data.entity.employee.Employee;
import com.sengulkaya.app.service.rest.payrollmanagement.data.entity.employee.Manager;
import com.sengulkaya.app.service.rest.payrollmanagement.dto.exception.repository.RepositoryException;
import com.sengulkaya.app.service.rest.payrollmanagement.dto.exception.service.DepartmentServiceException;
import com.sengulkaya.app.service.rest.payrollmanagement.dto.exception.service.ManagerServiceException;
import com.sengulkaya.app.service.rest.payrollmanagement.dto.requestDTO.ManagerRequestDTO;
import com.sengulkaya.app.service.rest.payrollmanagement.dto.responseDTO.ManagerResponseDTO;
import com.sengulkaya.app.service.rest.payrollmanagement.mapper.ManagerMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ManagerService {
    private final ServiceDAL serviceDAL;
    private final ManagerMapper managerMapper;

    public ManagerService(ServiceDAL serviceDAL,
                          ManagerMapper managerMapper)
    {
        this.serviceDAL = serviceDAL;
        this.managerMapper = managerMapper;
    }

   //I wanted to write one try catch block to use for all the same kind of methods
    // but ı did not know how to use the parameters in lambda for that because of the fact that parameters must be final.
    @Transactional
    public ManagerResponseDTO saveManager(ManagerRequestDTO managerRequestDTO)
    {
        try {
            Department department = serviceDAL.findDepartmentById(managerRequestDTO.getDepartmentId());
            Manager manager = serviceDAL.saveManager(managerMapper.toManager(managerRequestDTO));
            department.getEmployees().add(manager);
            manager.setDepartment(serviceDAL.saveDepartment(department));

            return managerMapper.toManagerResponseDTO(manager);
        } catch (RepositoryException ex) {
            System.out.printf("%s: %s", ex.getMessage(), ex.getCause());
            throw new ManagerServiceException("ManagerService.saveManager", ex.getCause());
        } catch (Throwable ex) {
            throw new ManagerServiceException("ManagerService.saveManager", ex);
        }
    }

    @Transactional
    public ManagerResponseDTO updateManager(Long employeeId, ManagerRequestDTO managerRequestDTO)
    {
        try {
            Manager found = serviceDAL.findManagerByEmployeeId(employeeId);

            found.setCitizenId(managerRequestDTO.getCitizenId());
            found.setName(managerRequestDTO.getName());
            found.setDateOfBirth(managerRequestDTO.getDateOfBirth());
            found.setJobTitle(managerRequestDTO.getJobTitle());
            found.setDateOfEmployment(managerRequestDTO.getDateOfEmployment());
            found.setDateOfLeave(managerRequestDTO.getDateOfLeave());
            found.setBaseSalary(managerRequestDTO.getBaseSalary());
            found.setRatePerHour(managerRequestDTO.getRatePerHour());
            found.setActive(managerRequestDTO.isActive());
            found.setDepartment(serviceDAL.findDepartmentById(managerRequestDTO.getDepartmentId()));

            return managerMapper.toManagerResponseDTO(serviceDAL.saveManager(found));
        } catch (RepositoryException ex) {
            System.out.printf("%s: %s", ex.getMessage(), ex.getCause());
            throw new ManagerServiceException("ManagerService.updateManager", ex.getCause());
        } catch (Throwable ex) {
            throw new ManagerServiceException("ManagerService.updateManager", ex);
        }
    }

    @Transactional
    public ManagerResponseDTO deleteManagerByEmployeeId(Long employeeId)
    {
        try {
            Manager manager = serviceDAL.findManagerByEmployeeId(employeeId);
            Department department = manager.getDepartment();

            Set<Employee> set = department.getEmployees();
            set.remove(manager);
            serviceDAL.saveDepartment(department);
            return managerMapper.toManagerResponseDTO
                    (serviceDAL.removeManager(manager));
        } catch (RepositoryException ex) {
            System.out.printf("%s: %s", ex.getMessage(), ex.getCause());
            throw new ManagerServiceException("ManagerService.deleteManagerByEmployeeId", ex.getCause());
        } catch (Throwable ex) {
            throw new ManagerServiceException("ManagerService.deleteManagerByEmployeeId", ex);
        }
    }

    public ManagerResponseDTO findManagerByEmployeeId(Long employeeId)
    {
        try {

            return managerMapper.toManagerResponseDTO(serviceDAL.findManagerByEmployeeId(employeeId));

        } catch (RepositoryException ex) {

            System.out.printf("%s: %s", ex.getMessage(), ex.getCause());
            throw new ManagerServiceException("ManagerService.findManagerByEmployeeId", ex.getCause());

        } catch (Throwable ex) {

            throw new ManagerServiceException("ManagerService.findManagerByEmployeeId", ex);
        }
    }

    public List<ManagerResponseDTO> findAllManagers()
    {
        try {

            return serviceDAL.findAllManagers().stream()
                    .map(managerMapper::toManagerResponseDTO)
                    .collect(Collectors.toList());

        } catch (RepositoryException ex) {

            System.out.printf("%s: %s", ex.getMessage(), ex.getCause());
            throw new ManagerServiceException("ManagerService.findAllManagers", ex.getCause());

        } catch (Throwable ex) {

            throw new ManagerServiceException("ManagerService.findAllManagers", ex);
        }
    }

}
