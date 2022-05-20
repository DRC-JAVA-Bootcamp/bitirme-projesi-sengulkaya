package com.sengulkaya.app.service.rest.payrollmanagement.mapper;

import com.sengulkaya.app.service.rest.payrollmanagement.data.entity.employee.ProjectWorker;
import com.sengulkaya.app.service.rest.payrollmanagement.dto.requestDTO.ProjectWorkerRequestDTO;
import com.sengulkaya.app.service.rest.payrollmanagement.dto.responseDTO.ProjectWorkerResponseDTO;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class ProjectWorkerMapper  {

    public ProjectWorker toProjectWorker(ProjectWorkerRequestDTO projectWorkerRequestDTO) {
        if ( projectWorkerRequestDTO == null ) {
            return null;
        }


        ProjectWorker projectWorker = new ProjectWorker();

        projectWorker.setCitizenId( projectWorkerRequestDTO.getCitizenId() );
        projectWorker.setName( projectWorkerRequestDTO.getName() );
        projectWorker.setDateOfBirth( projectWorkerRequestDTO.getDateOfBirth() );
        projectWorker.setJobTitle( projectWorkerRequestDTO.getJobTitle() );
        projectWorker.setDateOfEmployment( projectWorkerRequestDTO.getDateOfEmployment() );
        projectWorker.setDateOfLeave( projectWorkerRequestDTO.getDateOfLeave() );
        projectWorker.setBaseSalary( projectWorkerRequestDTO.getBaseSalary() );
        projectWorker.setRatePerHour( projectWorkerRequestDTO.getRatePerHour() );
        projectWorker.setActive( projectWorkerRequestDTO.isActive() );
        projectWorker.setDepartmentId( projectWorkerRequestDTO.getDepartmentId() );
        projectWorker.setProjectName( projectWorkerRequestDTO.getProjectName() );


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
                .setDepartmentId( projectWorker.getDepartment().getDepartmentId())
                .setEmployeeId( projectWorker.getEmployeeId())
                .setProjectName(projectWorker.getProjectName());

        return projectWorkerResponseDTO;
    }
}
