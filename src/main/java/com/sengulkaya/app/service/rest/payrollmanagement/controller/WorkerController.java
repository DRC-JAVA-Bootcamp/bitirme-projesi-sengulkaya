package com.sengulkaya.app.service.rest.payrollmanagement.controller;

import com.sengulkaya.app.service.rest.payrollmanagement.dto.requestDTO.WorkerRequestDTO;
import com.sengulkaya.app.service.rest.payrollmanagement.dto.responseDTO.WorkerResponseDTO;
import com.sengulkaya.app.service.rest.payrollmanagement.service.WorkerService;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PostMapping("/update/{id}")
    public WorkerResponseDTO updateWorker(@PathVariable("id") Long employeeId, @RequestBody WorkerRequestDTO workerRequestDTO)
    {
        return workerService.updateWorker(employeeId, workerRequestDTO);
    }

    @PostMapping("/delete")
    public WorkerResponseDTO deleteWorker(@RequestParam("employeeId") Long employeeId)
    {
        return workerService.deleteWorkerByEmployeeId(employeeId);
    }
    @GetMapping("/find/citizenId")
    public WorkerResponseDTO findWorkerByEmployeeId(@RequestParam("employeeId") Long employeeId)
    {
        return workerService.findWorkerByEmployeeId(employeeId);
    }

    @GetMapping("/all")
    public List<WorkerResponseDTO> findAllProjectWorkers()
    {
        return workerService.findAllWorkers();
    }
}
