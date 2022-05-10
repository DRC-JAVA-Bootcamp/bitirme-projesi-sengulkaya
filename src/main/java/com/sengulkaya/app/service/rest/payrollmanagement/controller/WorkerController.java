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

    @PostMapping("/save")//works
    public WorkerResponseDTO saveWorker(@RequestBody WorkerRequestDTO workerRequestDTO) throws Exception
    {
       return workerService.saveWorker(workerRequestDTO);
    }

    @PostMapping("/update/{id}")//works
    public WorkerResponseDTO updateWorker(@PathVariable("id") Long employeeId, @RequestBody WorkerRequestDTO workerRequestDTO)
    {
        return workerService.updateWorker(employeeId, workerRequestDTO);
    }

    @PostMapping("/delete/employeeId")//works
    public WorkerResponseDTO deleteWorker(@RequestParam("employeeId") Long employeeId)
    {
        return workerService.deleteWorkerByEmployeeId(employeeId);
    }
    @GetMapping("/find/employeeId")//works
    public WorkerResponseDTO findWorkerByEmployeeId(@RequestParam("employeeId") Long employeeId)
    {
        return workerService.findWorkerByEmployeeId(employeeId);
    }

    @GetMapping("/all")//works
    public List<WorkerResponseDTO> findAllWorkers()
    {
        return workerService.findAllWorkers();
    }
}
