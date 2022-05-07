package com.sengulkaya.app.service.rest.payrollmanagement.controller;

import com.sengulkaya.app.service.rest.payrollmanagement.dto.requestDTO.ManagerRequestDTO;
import com.sengulkaya.app.service.rest.payrollmanagement.dto.requestDTO.WorkerRequestDTO;
import com.sengulkaya.app.service.rest.payrollmanagement.dto.responseDTO.WorkerResponseDTO;
import com.sengulkaya.app.service.rest.payrollmanagement.service.WorkerService;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/worker")
@Scope("prototype")
public class WorkerController {
    private final WorkerService workerService;

    public WorkerController(WorkerService workerService)
    {
        this.workerService = workerService;
    }

    @PostMapping("/save")
    public WorkerResponseDTO saveWorker(WorkerRequestDTO workerRequestDTO) throws Exception
    {
       return workerService.saveWorker(workerRequestDTO);
    }

}
