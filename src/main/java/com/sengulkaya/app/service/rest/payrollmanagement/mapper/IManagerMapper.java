package com.sengulkaya.app.service.rest.payrollmanagement.mapper;

import com.sengulkaya.app.service.rest.payrollmanagement.data.entity.employee.Manager;
import com.sengulkaya.app.service.rest.payrollmanagement.data.entity.employee.Worker;
import com.sengulkaya.app.service.rest.payrollmanagement.dto.requestDTO.ManagerRequestDTO;
import com.sengulkaya.app.service.rest.payrollmanagement.dto.requestDTO.WorkerRequestDTO;
import com.sengulkaya.app.service.rest.payrollmanagement.dto.responseDTO.ManagerResponseDTO;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(implementationName = "ManagerMapperImpl", componentModel = "spring")
public interface IManagerMapper {
    @BeanMapping(ignoreByDefault = true)
    @Mapping(source = "dateOfBirth", target = "dateOfBirth", dateFormat = "dd/MM/yyyy")
    @Mapping(source = "dateOfEmployment", target = "dateOfEmployment", dateFormat = "dd/MM/yyyy")
    Manager toManager(ManagerRequestDTO managerRequestDTO);

    @BeanMapping(ignoreByDefault = true)
    @Mapping(source = "dateOfBirth", target = "dateOfBirth", dateFormat = "dd/MM/yyyy")
    @Mapping(source = "dateOfEmployment", target = "dateOfEmployment", dateFormat = "dd/MM/yyyy")
    ManagerResponseDTO toManagerResponseDTO(Manager manager);
}
