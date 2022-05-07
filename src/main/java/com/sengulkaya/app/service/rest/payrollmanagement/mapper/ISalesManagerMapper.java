package com.sengulkaya.app.service.rest.payrollmanagement.mapper;

import com.sengulkaya.app.service.rest.payrollmanagement.data.entity.employee.SalesManager;
import com.sengulkaya.app.service.rest.payrollmanagement.dto.requestDTO.SalesManagerRequestDTO;
import com.sengulkaya.app.service.rest.payrollmanagement.dto.responseDTO.SalesManagerResponseDTO;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(implementationName = "SalesManagerMapperImpl", componentModel = "spring")
public interface ISalesManagerMapper {
    @BeanMapping(ignoreByDefault = true)
    @Mapping(source = "dateOfBirth", target = "dateOfBirth", dateFormat = "dd/MM/yyyy")
    @Mapping(source = "dateOfEmployment", target = "dateOfEmployment", dateFormat = "dd/MM/yyyy")
    SalesManager toSalesManager(SalesManagerRequestDTO salesManagerRequestDTO);

    @BeanMapping(ignoreByDefault = true)
    @Mapping(source = "dateOfBirth", target = "dateOfBirth", dateFormat = "dd/MM/yyyy")
    @Mapping(source = "dateOfEmployment", target = "dateOfEmployment", dateFormat = "dd/MM/yyyy")
    SalesManagerResponseDTO toSalesManagerResponseDTO(SalesManager salesManager);
}
