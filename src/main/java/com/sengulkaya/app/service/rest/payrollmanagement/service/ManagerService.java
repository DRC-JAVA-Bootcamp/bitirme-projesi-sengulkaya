package com.sengulkaya.app.service.rest.payrollmanagement.service;

import com.sengulkaya.app.service.rest.payrollmanagement.data.dal.ServiceDAL;
import com.sengulkaya.app.service.rest.payrollmanagement.data.entity.employee.Department;
import com.sengulkaya.app.service.rest.payrollmanagement.data.entity.employee.Employee;
import com.sengulkaya.app.service.rest.payrollmanagement.data.entity.employee.Manager;
import com.sengulkaya.app.service.rest.payrollmanagement.dto.requestDTO.ManagerRequestDTO;
import com.sengulkaya.app.service.rest.payrollmanagement.dto.responseDTO.ManagerResponseDTO;
import com.sengulkaya.app.service.rest.payrollmanagement.mapper.ManagerMapper;
import org.springframework.stereotype.Service;

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

    public ManagerResponseDTO saveManager(ManagerRequestDTO managerRequestDTO)
    {
        return managerMapper.toManagerResponseDTO
                (serviceDAL.saveManager(managerMapper.toManager(managerRequestDTO)));
    }

    public ManagerResponseDTO updateManager(ManagerRequestDTO managerRequestDTO)
    {
        Manager found = serviceDAL.findManagerById(managerRequestDTO.getCitizenId());

        found.setName(managerRequestDTO.getName());
        found.setDateOfBirth(managerRequestDTO.getDateOfBirth());
        found.setDepartment(serviceDAL.findDepartmentByName(managerRequestDTO.getDepartment()));
        found.setJobTitle(managerRequestDTO.getJobTitle());
        found.setDateOfEmployment(managerRequestDTO.getDateOfEmployment());
        found.setBaseSalary(managerRequestDTO.getBaseSalary());
        found.setRatePerHour(managerRequestDTO.getRatePerHour());
        found.setActive(managerRequestDTO.isActive());

        return managerMapper.toManagerResponseDTO(serviceDAL.saveManager(found));
    }

    public ManagerResponseDTO deleteManagerByCitizenId(String citizenId)
    {
        Manager manager = serviceDAL.findManagerById(citizenId);
        Department department = manager.getDepartment();

        Set<Employee> set = department.getEmployees();
        set.remove(manager);
        //manager.setEmployees(set);
        serviceDAL.saveDepartment(department);
        return managerMapper.toManagerResponseDTO
                (serviceDAL.removeManager(manager));
    }

    public ManagerResponseDTO findManagerByCitizenId(String citizenId)
    {
        return managerMapper.toManagerResponseDTO(serviceDAL.findManagerById(citizenId));
    }

    public List<ManagerResponseDTO> findAllManagers()
    {
        return serviceDAL.findAllManagers().stream()
                .map(managerMapper::toManagerResponseDTO)
                .collect(Collectors.toList());
    }

}
