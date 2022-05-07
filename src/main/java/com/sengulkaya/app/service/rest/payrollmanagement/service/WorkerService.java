package com.sengulkaya.app.service.rest.payrollmanagement.service;

import com.sengulkaya.app.service.rest.payrollmanagement.data.dal.ServiceDAL;
import com.sengulkaya.app.service.rest.payrollmanagement.dto.requestDTO.WorkerRequestDTO;
import com.sengulkaya.app.service.rest.payrollmanagement.dto.responseDTO.WorkerResponseDTO;
import com.sengulkaya.app.service.rest.payrollmanagement.mapper.IWorkerMapper;

import java.util.List;

public class WorkerService {
    private final ServiceDAL serviceDAL;
    private final IWorkerMapper workerMapper;

   public WorkerService(ServiceDAL serviceDAL,
                        IWorkerMapper workerMapper)
   {
       this.serviceDAL = serviceDAL;
       this.workerMapper = workerMapper;
   }

   public WorkerResponseDTO saveWorker(WorkerRequestDTO workerRequestDTO)
   {
       return workerMapper.toWorkerResponseDTO(serviceDAL.saveWorker(workerMapper.toWorker(workerRequestDTO)));
   }

    public WorkerResponseDTO updateWorker(WorkerRequestDTO workerRequestDTO)
    {
        //
    }

    public WorkerResponseDTO removeWorkerById(Long workerId)
    {

    }

    public List<WorkerResponseDTO> findAllWorkers()
    {

    }
}
