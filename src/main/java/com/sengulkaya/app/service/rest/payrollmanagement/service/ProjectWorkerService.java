package com.sengulkaya.app.service.rest.payrollmanagement.service;

import com.sengulkaya.app.service.rest.payrollmanagement.data.dal.ServiceDAL;
import com.sengulkaya.app.service.rest.payrollmanagement.data.entity.employee.*;
import com.sengulkaya.app.service.rest.payrollmanagement.dto.requestDTO.ProjectWorkerRequestDTO;
import com.sengulkaya.app.service.rest.payrollmanagement.dto.responseDTO.ProjectWorkerResponseDTO;
import com.sengulkaya.app.service.rest.payrollmanagement.mapper.ProjectWorkerMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


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

    @Transactional
    public ProjectWorkerResponseDTO saveProjectWorker(ProjectWorkerRequestDTO projectWorkerRequestDTO)
    {
        Department department = serviceDAL.findDepartmentById(projectWorkerRequestDTO.getDepartmentId());
               ProjectWorker projectWorker = serviceDAL.saveProjectWorker(projectWorkerMapper.toProjectWorker(projectWorkerRequestDTO));
               department.getEmployees().add(projectWorker);//??
               serviceDAL.saveDepartment(department);
               projectWorker.setDepartment(serviceDAL.saveDepartment(department));

               return projectWorkerMapper.toProjectWorkerResponseDTO(projectWorker);

    }

    @Transactional
    public ProjectWorkerResponseDTO updateProjectWorker(Long employeeId, ProjectWorkerRequestDTO projectWorkerRequestDTO)
    {
        ProjectWorker found = serviceDAL.findProjectWorkerByEmployeeId(employeeId);

        // private String citizenId;
        //    private String name;
        //    private LocalDate dateOfBirth;//Retirement benefits?
        //    private String jobTitle;
        //    private LocalDate dateOfEmployment;
        //    private LocalDate dateOfLeave;
        //    private double baseSalary;
        //    private double ratePerHour;
        //    private boolean active;
        //    private Long departmentId;
        found.setCitizenId(projectWorkerRequestDTO.getCitizenId());
        found.setName(projectWorkerRequestDTO.getName());
        found.setDateOfBirth(projectWorkerRequestDTO.getDateOfBirth());
        found.setDepartment(serviceDAL.findDepartmentById(projectWorkerRequestDTO.getDepartmentId()));
        found.setJobTitle(projectWorkerRequestDTO.getJobTitle());
        found.setDateOfEmployment(projectWorkerRequestDTO.getDateOfEmployment());
        found.setDateOfLeave(projectWorkerRequestDTO.getDateOfLeave());
        found.setBaseSalary(projectWorkerRequestDTO.getBaseSalary());
        found.setRatePerHour(projectWorkerRequestDTO.getRatePerHour());
        found.setProjectName(projectWorkerRequestDTO.getProjectName());
        found.setActive(projectWorkerRequestDTO.isActive());
        found.setDepartmentId(projectWorkerRequestDTO.getDepartmentId());

        return projectWorkerMapper.toProjectWorkerResponseDTO(serviceDAL.saveProjectWorker(found));
    }

    @Transactional
    public ProjectWorkerResponseDTO deleteProjectWorkerByEmployeeId(Long employeeId)
    {
        ProjectWorker projectWorker = serviceDAL.findProjectWorkerByEmployeeId(employeeId);
        Department department = projectWorker.getDepartment();

        Set<Employee> set = department.getEmployees();
        set.remove(projectWorker);
        //projectWorker.setEmployees(set);
        serviceDAL.saveDepartment(department);
        return projectWorkerMapper.toProjectWorkerResponseDTO
                (serviceDAL.removeProjectWorker(projectWorker));
    }

    public ProjectWorkerResponseDTO findProjectWorkerByEmployeeId(Long employeeId)
    {
        return projectWorkerMapper.toProjectWorkerResponseDTO(serviceDAL.findProjectWorkerByEmployeeId(employeeId));
    }

    public List<ProjectWorkerResponseDTO> findAllProjectWorkers()
    {
        return serviceDAL.findAllProjectWorkers().stream()
                .map(projectWorkerMapper::toProjectWorkerResponseDTO)
                .collect(Collectors.toList());
    }

}
