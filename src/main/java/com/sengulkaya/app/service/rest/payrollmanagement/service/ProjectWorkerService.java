package com.sengulkaya.app.service.rest.payrollmanagement.service;

import com.sengulkaya.app.service.rest.payrollmanagement.data.dal.ServiceDAL;
import com.sengulkaya.app.service.rest.payrollmanagement.data.entity.employee.*;
import com.sengulkaya.app.service.rest.payrollmanagement.dto.requestDTO.ProjectWorkerRequestDTO;
import com.sengulkaya.app.service.rest.payrollmanagement.dto.responseDTO.ProjectWorkerResponseDTO;
import com.sengulkaya.app.service.rest.payrollmanagement.mapper.ProjectWorkerMapper;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ProjectWorkerService  {
    private final ServiceDAL serviceDAL;
    private final ProjectWorkerMapper projectWorkerMapper;

    public ProjectWorkerService(ServiceDAL serviceDAL,
                                ProjectWorkerMapper projectWorkerMapper)
    {
        this.serviceDAL = serviceDAL;
        this.projectWorkerMapper = projectWorkerMapper;
    }

    public ProjectWorkerResponseDTO saveProjectWorker(ProjectWorkerRequestDTO projectWorkerRequestDTO)
    {
        return projectWorkerMapper.toProjectWorkerResponseDTO
                (serviceDAL.saveProjectWorker(projectWorkerMapper.toProjectWorker(projectWorkerRequestDTO)));
    }

    public ProjectWorkerResponseDTO updateProjectWorker(ProjectWorkerRequestDTO projectWorkerRequestDTO)
    {
        ProjectWorker found = serviceDAL.findProjectWorkerById(projectWorkerRequestDTO.getCitizenId());

        found.setName(projectWorkerRequestDTO.getName());
        found.setDateOfBirth(projectWorkerRequestDTO.getDateOfBirth());
        found.setDepartment(serviceDAL.findDepartmentByName(projectWorkerRequestDTO.getDepartment()));
        found.setJobTitle(projectWorkerRequestDTO.getJobTitle());
        found.setDateOfEmployment(projectWorkerRequestDTO.getDateOfEmployment());
        found.setBaseSalary(projectWorkerRequestDTO.getBaseSalary());
        found.setRatePerHour(projectWorkerRequestDTO.getRatePerHour());
        found.setProjectName(projectWorkerRequestDTO.getProjectName());
        found.setActive(projectWorkerRequestDTO.isActive());

        return projectWorkerMapper.toProjectWorkerResponseDTO(serviceDAL.saveProjectWorker(found));
    }

    public ProjectWorkerResponseDTO deleteProjectWorkerByCitizenId(String citizenId)
    {
        ProjectWorker projectWorker = serviceDAL.findProjectWorkerById(citizenId);
        Department department = projectWorker.getDepartment();

        Set<Employee> set = department.getEmployees();
        set.remove(projectWorker);
        //projectWorker.setEmployees(set);
        serviceDAL.saveDepartment(department);
        return projectWorkerMapper.toProjectWorkerResponseDTO
                (serviceDAL.removeProjectWorker(projectWorker));
    }

    public ProjectWorkerResponseDTO findProjectWorkerByCitizenId(String citizenId)
    {
        return projectWorkerMapper.toProjectWorkerResponseDTO(serviceDAL.findProjectWorkerById(citizenId));
    }

    public List<ProjectWorkerResponseDTO> findAllProjectWorkers()
    {
        return serviceDAL.findAllProjectWorkers().stream()
                .map(projectWorkerMapper::toProjectWorkerResponseDTO)
                .collect(Collectors.toList());
    }

}
