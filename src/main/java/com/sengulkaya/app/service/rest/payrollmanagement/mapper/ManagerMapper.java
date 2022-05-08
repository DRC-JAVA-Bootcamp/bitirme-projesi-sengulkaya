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

        manager.setDateOfBirth( managerRequestDTO.getDateOfBirth() );
        manager.setDateOfEmployment( managerRequestDTO.getDateOfEmployment() );

        return manager;
    }


    public ManagerResponseDTO toManagerResponseDTO(Manager manager) {
        if ( manager == null ) {
            return null;
        }

        ManagerResponseDTO managerResponseDTO = new ManagerResponseDTO();

        managerResponseDTO.setDateOfBirth( manager.getDateOfBirth() );
        managerResponseDTO.setDateOfEmployment( manager.getDateOfEmployment() );

        return managerResponseDTO;
    }
}
