package com.sengulkaya.app.service.rest.payrollmanagement.mapper;

import com.sengulkaya.app.service.rest.payrollmanagement.data.entity.employee.Worker;
import com.sengulkaya.app.service.rest.payrollmanagement.dto.requestDTO.WorkerRequestDTO;
import com.sengulkaya.app.service.rest.payrollmanagement.dto.responseDTO.WorkerResponseDTO;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(implementationName = "WorkerMapperImpl", componentModel = "spring")
public interface IWorkerMapper {
    @BeanMapping(ignoreByDefault = true)
    @Mapping(source = "dateOfBirth", target = "dateOfBirth", dateFormat = "dd/MM/yyyy")
    @Mapping(source = "dateOfEmployment", target = "dateOfEmployment", dateFormat = "dd/MM/yyyy")
    Worker toWorker(WorkerRequestDTO workerRequestDTO);

    @BeanMapping(ignoreByDefault = true)
    @Mapping(source = "dateOfBirth", target = "dateOfBirth", dateFormat = "dd/MM/yyyy")
    @Mapping(source = "dateOfEmployment", target = "dateOfEmployment", dateFormat = "dd/MM/yyyy")
    WorkerResponseDTO toWorkerResponseDTO(Worker worker);
}
