package com.sengulkaya.app.service.rest.payrollmanagement.mapper;

import com.sengulkaya.app.service.rest.payrollmanagement.data.entity.employee.Worker;
import com.sengulkaya.app.service.rest.payrollmanagement.dto.requestDTO.WorkerRequestDTO;
import com.sengulkaya.app.service.rest.payrollmanagement.dto.responseDTO.WorkerResponseDTO;

import org.springframework.stereotype.Component;

@Component
public class WorkerMapper {

    public Worker toWorker(WorkerRequestDTO workerRequestDTO) {
        if ( workerRequestDTO == null ) {
            return null;
        }

        Worker worker = new Worker();

        worker.setDateOfBirth( workerRequestDTO.getDateOfBirth() );
        worker.setDateOfEmployment( workerRequestDTO.getDateOfEmployment() );

        return worker;
    }

    public WorkerResponseDTO toWorkerResponseDTO(Worker worker) {
        if ( worker == null ) {
            return null;
        }

        WorkerResponseDTO workerResponseDTO = new WorkerResponseDTO();

        workerResponseDTO.setDateOfBirth( worker.getDateOfBirth() );
        workerResponseDTO.setDateOfEmployment( worker.getDateOfEmployment() );

        return workerResponseDTO;
    }
}
