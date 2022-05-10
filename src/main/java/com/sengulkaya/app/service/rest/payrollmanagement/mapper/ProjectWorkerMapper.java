package com.sengulkaya.app.service.rest.payrollmanagement.mapper;

import com.sengulkaya.app.service.rest.payrollmanagement.data.entity.employee.ProjectWorker;
import com.sengulkaya.app.service.rest.payrollmanagement.dto.requestDTO.ProjectWorkerRequestDTO;
import com.sengulkaya.app.service.rest.payrollmanagement.dto.responseDTO.ProjectWorkerResponseDTO;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

@Component
public class ProjectWorkerMapper  {

    public ProjectWorker toProjectWorker(ProjectWorkerRequestDTO projectWorkerRequestDTO) {
        if ( projectWorkerRequestDTO == null ) {
            return null;
        }

        ProjectWorker projectWorker = new ProjectWorker();

        projectWorker.setDateOfBirth( projectWorkerRequestDTO.getDateOfBirth() );
        projectWorker.setDateOfEmployment( projectWorkerRequestDTO.getDateOfEmployment() );

        return projectWorker;
    }

    public ProjectWorkerResponseDTO toProjectWorkerResponseDTO(ProjectWorker projectWorker) {
        if ( projectWorker == null ) {
            return null;
        }

        ProjectWorkerResponseDTO projectWorkerResponseDTO = new ProjectWorkerResponseDTO();


        projectWorkerResponseDTO.setCitizenId( projectWorker.getCitizenId() )
                .setName( projectWorker.getName())
                .setDateOfBirth( projectWorker.getDateOfBirth() )
                .setDepartmentName(projectWorker.getDepartment().getDepartmentName())
                .setJobTitle( projectWorker.getJobTitle())
                .setDepartmentName( projectWorker.getDepartment().getDepartmentName())
                .setDateOfEmployment( projectWorker.getDateOfEmployment() )
                .setBaseSalary( projectWorker.getBaseSalary())
                .setRatePerHour( projectWorker.getRatePerHour())
                .setActive( projectWorker.isActive())
                .setDepartmentId( projectWorker.getDepartmentId())
                .setEmployeeId( projectWorker.getEmployeeId())
                .setProjectName(projectWorker.getProjectName());

        return projectWorkerResponseDTO;
    }
}