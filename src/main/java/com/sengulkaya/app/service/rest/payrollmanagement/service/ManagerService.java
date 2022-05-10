package com.sengulkaya.app.service.rest.payrollmanagement.service;

import com.sengulkaya.app.service.rest.payrollmanagement.data.dal.ServiceDAL;
import com.sengulkaya.app.service.rest.payrollmanagement.data.entity.employee.Department;
import com.sengulkaya.app.service.rest.payrollmanagement.data.entity.employee.Employee;
import com.sengulkaya.app.service.rest.payrollmanagement.data.entity.employee.Manager;
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

    @Transactional
    public ManagerResponseDTO saveManager(ManagerRequestDTO managerRequestDTO)
    {
        Department department = serviceDAL.findDepartmentById(managerRequestDTO.getDepartmentId());
        Manager manager = serviceDAL.saveManager(managerMapper.toManager(managerRequestDTO));
        department.getEmployees().add(manager);
        manager.setDepartment(serviceDAL.saveDepartment(department));

        return managerMapper.toManagerResponseDTO(manager);
    }

    @Transactional
    public ManagerResponseDTO updateManager(Long employeeId, ManagerRequestDTO managerRequestDTO)
    {
        Manager found = serviceDAL.findManagerByEmployeeId(employeeId);


        found.setCitizenId(managerRequestDTO.getCitizenId());
        found.setName(managerRequestDTO.getName());
        found.setDateOfBirth(managerRequestDTO.getDateOfBirth());
        found.setDepartment(serviceDAL.findDepartmentById(managerRequestDTO.getDepartmentId()));
        found.setJobTitle(managerRequestDTO.getJobTitle());
        found.setDateOfEmployment(managerRequestDTO.getDateOfEmployment());
        found.setBaseSalary(managerRequestDTO.getBaseSalary());
        found.setRatePerHour(managerRequestDTO.getRatePerHour());
        found.setActive(managerRequestDTO.isActive());


        return managerMapper.toManagerResponseDTO(serviceDAL.saveManager(found));
    }

    @Transactional
    public ManagerResponseDTO deleteManagerByEmployeeId(Long employeeId)
    {
        Manager manager = serviceDAL.findManagerByEmployeeId(employeeId);
        Department department = manager.getDepartment();

        Set<Employee> set = department.getEmployees();
        set.remove(manager);
        //manager.setEmployees(set);
        serviceDAL.saveDepartment(department);
        return managerMapper.toManagerResponseDTO
                (serviceDAL.removeManager(manager));
    }

    public ManagerResponseDTO findManagerByEmployeeId(Long employeeId)
    {
        return managerMapper.toManagerResponseDTO(serviceDAL.findManagerByEmployeeId(employeeId));
    }

    public List<ManagerResponseDTO> findAllManagers()
    {
        return serviceDAL.findAllManagers().stream()
                .map(managerMapper::toManagerResponseDTO)
                .collect(Collectors.toList());
    }

}
