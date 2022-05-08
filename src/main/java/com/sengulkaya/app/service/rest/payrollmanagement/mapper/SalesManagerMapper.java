package com.sengulkaya.app.service.rest.payrollmanagement.mapper;

import com.sengulkaya.app.service.rest.payrollmanagement.data.entity.employee.SalesManager;
import com.sengulkaya.app.service.rest.payrollmanagement.dto.requestDTO.SalesManagerRequestDTO;
import com.sengulkaya.app.service.rest.payrollmanagement.dto.responseDTO.SalesManagerResponseDTO;
import org.springframework.stereotype.Component;

@Component
public class SalesManagerMapper {

    public SalesManager toSalesManager(SalesManagerRequestDTO salesManagerRequestDTO) {
        if ( salesManagerRequestDTO == null ) {
            return null;
        }

        SalesManager salesManager = new SalesManager();

        salesManager.setDateOfBirth( salesManagerRequestDTO.getDateOfBirth() );
        salesManager.setDateOfEmployment( salesManagerRequestDTO.getDateOfEmployment() );

        return salesManager;
    }


    public SalesManagerResponseDTO toSalesManagerResponseDTO(SalesManager salesManager) {
        if ( salesManager == null ) {
            return null;
        }

        SalesManagerResponseDTO salesManagerResponseDTO = new SalesManagerResponseDTO();

        salesManagerResponseDTO.setDateOfBirth( salesManager.getDateOfBirth() );
        salesManagerResponseDTO.setDateOfEmployment( salesManager.getDateOfEmployment() );

        return salesManagerResponseDTO;
    }
}
