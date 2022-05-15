package com.sengulkaya.app.service.rest.payrollmanagement.service;

import com.sengulkaya.app.service.rest.payrollmanagement.data.dal.ServiceDAL;
import com.sengulkaya.app.service.rest.payrollmanagement.data.entity.employee.*;
import com.sengulkaya.app.service.rest.payrollmanagement.dto.exception.repository.RepositoryException;
import com.sengulkaya.app.service.rest.payrollmanagement.dto.exception.service.ManagerServiceException;
import com.sengulkaya.app.service.rest.payrollmanagement.dto.exception.service.ProjectWorkerServiceException;
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
        try {

            Department department = serviceDAL.findDepartmentById(projectWorkerRequestDTO.getDepartmentId());
            ProjectWorker projectWorker = serviceDAL.saveProjectWorker(projectWorkerMapper.toProjectWorker(projectWorkerRequestDTO));
            department.getEmployees().add(projectWorker);//??
            serviceDAL.saveDepartment(department);
            projectWorker.setDepartment(serviceDAL.saveDepartment(department));

            return projectWorkerMapper.toProjectWorkerResponseDTO(projectWorker);

        } catch (RepositoryException ex) {

            System.out.printf("%s: %s", ex.getMessage(), ex.getCause());
            throw new ProjectWorkerServiceException("ProjectWorkerService.saveProjectWorker", ex.getCause());

        } catch (Throwable ex) {

            throw new ProjectWorkerServiceException("ProjectWorkerService.saveProjectWorker", ex);
        }
    }

    @Transactional
    public ProjectWorkerResponseDTO updateProjectWorker(Long employeeId, ProjectWorkerRequestDTO projectWorkerRequestDTO)
    {
        try {

            ProjectWorker found = serviceDAL.findProjectWorkerByEmployeeId(employeeId);

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

        } catch (RepositoryException ex) {

            System.out.printf("%s: %s", ex.getMessage(), ex.getCause());
            throw new ProjectWorkerServiceException("ProjectWorkerService.updateProjectWorker", ex.getCause());

        } catch (Throwable ex) {

            throw new ProjectWorkerServiceException("ProjectWorkerService.updateProjectWorker", ex);
        }
    }

    @Transactional
    public ProjectWorkerResponseDTO deleteProjectWorkerByEmployeeId(Long employeeId)
    {
        try {

            ProjectWorker projectWorker = serviceDAL.findProjectWorkerByEmployeeId(employeeId);
            Department department = projectWorker.getDepartment();

            Set<Employee> set = department.getEmployees();
            set.remove(projectWorker);
            serviceDAL.saveDepartment(department);
            return projectWorkerMapper.toProjectWorkerResponseDTO
                    (serviceDAL.removeProjectWorker(projectWorker));

        } catch (RepositoryException ex) {

            System.out.printf("%s: %s", ex.getMessage(), ex.getCause());
            throw new ProjectWorkerServiceException("ProjectWorkerService.deleteProjectWorkerByEmployeeId", ex.getCause());

        } catch (Throwable ex) {

            throw new ProjectWorkerServiceException("ProjectWorkerService.deleteProjectWorkerByEmployeeId", ex);
        }
    }

    public ProjectWorkerResponseDTO findProjectWorkerByEmployeeId(Long employeeId)
    {
        try {

            return projectWorkerMapper.toProjectWorkerResponseDTO(serviceDAL.findProjectWorkerByEmployeeId(employeeId));

        } catch (RepositoryException ex) {

            System.out.printf("%s: %s", ex.getMessage(), ex.getCause());
            throw new ProjectWorkerServiceException("ProjectWorkerService.findProjectWorkerByEmployeeId", ex.getCause());

        } catch (Throwable ex) {

            throw new ProjectWorkerServiceException("ProjectWorkerService.findProjectWorkerByEmployeeId", ex);
        }
    }

    public List<ProjectWorkerResponseDTO> findAllProjectWorkers()
    {
        try {

            return serviceDAL.findAllProjectWorkers().stream()
                    .map(projectWorkerMapper::toProjectWorkerResponseDTO)
                    .collect(Collectors.toList());

        } catch (RepositoryException ex) {

            System.out.printf("%s: %s", ex.getMessage(), ex.getCause());
            throw new ProjectWorkerServiceException("ProjectWorkerService.findAllProjectWorkers", ex.getCause());

        } catch (Throwable ex) {

            throw new ProjectWorkerServiceException("ProjectWorkerService.findAllProjectWorkers", ex);
        }
    }

}
