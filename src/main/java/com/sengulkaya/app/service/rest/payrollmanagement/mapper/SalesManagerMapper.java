package com.sengulkaya.app.service.rest.payrollmanagement.mapper;

import com.sengulkaya.app.service.rest.payrollmanagement.data.entity.employee.Manager;
import com.sengulkaya.app.service.rest.payrollmanagement.data.entity.employee.SalesManager;
import com.sengulkaya.app.service.rest.payrollmanagement.dto.requestDTO.ManagerRequestDTO;
import com.sengulkaya.app.service.rest.payrollmanagement.dto.requestDTO.SalesManagerRequestDTO;
import com.sengulkaya.app.service.rest.payrollmanagement.dto.responseDTO.ManagerResponseDTO;
import com.sengulkaya.app.service.rest.payrollmanagement.dto.responseDTO.SalesManagerResponseDTO;
import org.springframework.stereotype.Component;

@Component
public class SalesManagerMapper extends ManagerMapper {
    public SalesManager toSalesManager(SalesManagerRequestDTO salesManagerRequestDTO)
    {
        if ( salesManagerRequestDTO == null ) {
        return null;
    }

        SalesManager salesManager = new SalesManager();

        salesManager.setCitizenId( salesManagerRequestDTO.getCitizenId());
        salesManager.setName( salesManagerRequestDTO.getName());
        salesManager.setDateOfBirth( salesManagerRequestDTO.getDateOfBirth());
        salesManager.setJobTitle(salesManagerRequestDTO.getJobTitle());
        salesManager.setDateOfEmployment( salesManagerRequestDTO.getDateOfEmployment() );
        salesManager.setDateOfLeave( salesManagerRequestDTO.getDateOfLeave() );
        salesManager.setBaseSalary( salesManagerRequestDTO.getBaseSalary() );
        salesManager.setRatePerHour( salesManagerRequestDTO.getRatePerHour() );
        salesManager.setActive( salesManagerRequestDTO.isActive());
        salesManager.setDepartmentId( salesManagerRequestDTO.getDepartmentId());
        salesManager.setSales( salesManagerRequestDTO.getSales());


        return salesManager;
    }


    public SalesManagerResponseDTO toSalesManagerResponseDTO(SalesManager salesManager)
    {
        if ( salesManager == null ) {
            return null;
        }



        SalesManagerResponseDTO salesManagerResponseDTO = new SalesManagerResponseDTO();


        //    private double sales;
        //    private Long departmentId;

        salesManagerResponseDTO.setCitizenId( salesManager.getCitizenId() )
            .setName( salesManager.getName())
            .setDateOfBirth( salesManager.getDateOfBirth() )
            .setJobTitle( salesManager.getJobTitle())
            .setDateOfEmployment( salesManager.getDateOfEmployment() )
            .setBaseSalary( salesManager.getBaseSalary())
            .setRatePerHour( salesManager.getRatePerHour())
            .setActive( salesManager.isActive())
            .setDepartmentId( salesManager.getDepartment().getDepartmentId())
            .setEmployeeId( salesManager.getEmployeeId())
                .setSales(salesManager.getSales())
                .setBonus(salesManager.getBonus());


        return salesManagerResponseDTO;
    }
}

