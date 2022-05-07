package com.sengulkaya.app.service.rest.payrollmanagement.mapper;

import com.sengulkaya.app.service.rest.payrollmanagement.data.entity.employee.ProjectWorker;
import com.sengulkaya.app.service.rest.payrollmanagement.dto.requestDTO.ProjectWorkerRequestDTO;
import com.sengulkaya.app.service.rest.payrollmanagement.dto.responseDTO.ProjectWorkerResponseDTO;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(implementationName = "ProjectWorkerMapperImpl", componentModel = "spring")
public interface IProjectWorkerMapper {
    @BeanMapping(ignoreByDefault = true)
    @Mapping(source = "dateOfBirth", target = "dateOfBirth", dateFormat = "dd/MM/yyyy")
    @Mapping(source = "dateOfEmployment", target = "dateOfEmployment", dateFormat = "dd/MM/yyyy")
    ProjectWorker toProjectWorker(ProjectWorkerRequestDTO projectWorkerRequestDTO);

    @BeanMapping(ignoreByDefault = true)
    @Mapping(source = "dateOfBirth", target = "dateOfBirth", dateFormat = "dd/MM/yyyy")
    @Mapping(source = "dateOfEmployment", target = "dateOfEmployment", dateFormat = "dd/MM/yyyy")
    ProjectWorkerResponseDTO toProjectWorkerResponseDTO(ProjectWorker projectWorker);
}
