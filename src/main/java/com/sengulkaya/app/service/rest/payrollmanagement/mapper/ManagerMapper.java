package com.sengulkaya.app.service.rest.payrollmanagement.mapper;

import com.sengulkaya.app.service.rest.payrollmanagement.data.entity.employee.Manager;
import com.sengulkaya.app.service.rest.payrollmanagement.dto.requestDTO.ManagerRequestDTO;
import com.sengulkaya.app.service.rest.payrollmanagement.dto.responseDTO.ManagerResponseDTO;
import org.springframework.stereotype.Component;

@Component
public class ManagerMapper {

    public Manager toManager(ManagerRequestDTO managerRequestDTO) {
        if ( managerRequestDTO == null ) {
            return null;
        }

        Manager manager = new Manager();

        manager.setCitizenId( managerRequestDTO.getCitizenId());
        manager.setName( managerRequestDTO.getName());
        manager.setDateOfBirth( managerRequestDTO.getDateOfBirth());
        manager.setJobTitle(managerRequestDTO.getJobTitle());
        manager.setDateOfEmployment( managerRequestDTO.getDateOfEmployment() );
        manager.setBaseSalary( managerRequestDTO.getBaseSalary() );
        manager.setRatePerHour( managerRequestDTO.getRatePerHour() );
        manager.setActive( managerRequestDTO.isActive());
        manager.setDepartmentId( managerRequestDTO.getDepartmentId());


        return manager;
    }


    public ManagerResponseDTO toManagerResponseDTO(Manager manager) {
        if ( manager == null ) {
            return null;
        }

        ManagerResponseDTO managerResponseDTO = new ManagerResponseDTO();

        managerResponseDTO.setCitizenId( manager.getCitizenId() )
                .setName( manager.getName())
                .setDateOfBirth( manager.getDateOfBirth() )
                .setJobTitle(manager.getJobTitle())
                .setDateOfEmployment( manager.getDateOfEmployment() )
                .setBaseSalary( manager.getBaseSalary())
                .setRatePerHour( manager.getRatePerHour())
                .setActive( manager.isActive())
                .setDepartmentId( manager.getDepartment().getDepartmentId())
                .setEmployeeId( manager.getEmployeeId());

        return managerResponseDTO;
    }
}
