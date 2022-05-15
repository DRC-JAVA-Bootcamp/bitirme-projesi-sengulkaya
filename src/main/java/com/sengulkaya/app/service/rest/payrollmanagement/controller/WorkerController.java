package com.sengulkaya.app.service.rest.payrollmanagement.controller;

import com.sengulkaya.app.service.rest.payrollmanagement.dto.requestDTO.WorkerRequestDTO;
import com.sengulkaya.app.service.rest.payrollmanagement.dto.responseDTO.SalesManagerResponseDTO;
import com.sengulkaya.app.service.rest.payrollmanagement.dto.responseDTO.WorkerResponseDTO;
import com.sengulkaya.app.service.rest.payrollmanagement.service.WorkerService;
import org.springframework.context.annotation.Scope;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<WorkerResponseDTO> saveWorker(@RequestBody WorkerRequestDTO workerRequestDTO) throws Exception
    {
        ResponseEntity<WorkerResponseDTO> responseEntity = ResponseEntity.badRequest().build();

        try {
            responseEntity = ResponseEntity.ok(       workerService.saveWorker(workerRequestDTO));

        } catch (Throwable ex) {
            System.out.printf("%s: %s", ex.getMessage(), ex.getCause());
        }
        return responseEntity;
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<WorkerResponseDTO> updateWorker(@PathVariable("id") Long employeeId, @RequestBody WorkerRequestDTO workerRequestDTO)
    {
        ResponseEntity<WorkerResponseDTO> responseEntity = ResponseEntity.badRequest().build();

        try {
            responseEntity = ResponseEntity.ok(       workerService.updateWorker(employeeId, workerRequestDTO));

        } catch (Throwable ex) {
            System.out.printf("%s: %s", ex.getMessage(), ex.getCause());
        }
        return responseEntity;
    }

    @PostMapping("/delete/employeeId")
    public ResponseEntity<WorkerResponseDTO> deleteWorker(@RequestParam("employeeId") Long employeeId)
    {
        ResponseEntity<WorkerResponseDTO> responseEntity = ResponseEntity.badRequest().build();

        try {
            responseEntity = ResponseEntity.ok(       workerService.deleteWorkerByEmployeeId(employeeId));

        } catch (Throwable ex) {
            System.out.printf("%s: %s", ex.getMessage(), ex.getCause());
        }
        return responseEntity;
    }
    @GetMapping("/find/employeeId")
    public ResponseEntity<WorkerResponseDTO> findWorkerByEmployeeId(@RequestParam("employeeId") Long employeeId)
    {
        ResponseEntity<WorkerResponseDTO> responseEntity = ResponseEntity.badRequest().build();

        try {
            responseEntity = ResponseEntity.ok(       workerService.findWorkerByEmployeeId(employeeId));

        } catch (Throwable ex) {
            System.out.printf("%s: %s", ex.getMessage(), ex.getCause());
        }
        return responseEntity;
    }

    @GetMapping("/all")
    public ResponseEntity<List<WorkerResponseDTO>> findAllWorkers()
    {
        ResponseEntity<List<WorkerResponseDTO>> responseEntity = ResponseEntity.badRequest().build();

        try {
            responseEntity = ResponseEntity.ok(       workerService.findAllWorkers());

        } catch (Throwable ex) {
            System.out.printf("%s: %s", ex.getMessage(), ex.getCause());
        }
        return responseEntity;
    }
}
