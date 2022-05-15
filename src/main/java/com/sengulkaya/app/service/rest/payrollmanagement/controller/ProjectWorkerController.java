package com.sengulkaya.app.service.rest.payrollmanagement.controller;

import com.sengulkaya.app.service.rest.payrollmanagement.dto.requestDTO.ProjectWorkerRequestDTO;
import com.sengulkaya.app.service.rest.payrollmanagement.dto.responseDTO.ManagerResponseDTO;
import com.sengulkaya.app.service.rest.payrollmanagement.dto.responseDTO.ProjectWorkerResponseDTO;
import com.sengulkaya.app.service.rest.payrollmanagement.service.ProjectWorkerService;
import org.springframework.context.annotation.Scope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/projectWorker")
@Scope("prototype")
public class ProjectWorkerController {
    private final ProjectWorkerService projectWorkerService;

    public ProjectWorkerController(ProjectWorkerService projectWorkerService)
    {
        this.projectWorkerService = projectWorkerService;
    }

    @PostMapping("/save")
    public ResponseEntity<ProjectWorkerResponseDTO> saveProjectWorker(@RequestBody ProjectWorkerRequestDTO projectWorkerRequestDTO)
    {
        ResponseEntity<ProjectWorkerResponseDTO> responseEntity = ResponseEntity.badRequest().build();

        try {
            responseEntity = ResponseEntity.ok(       projectWorkerService.saveProjectWorker(projectWorkerRequestDTO));

        } catch (Throwable ex) {
            System.out.printf("%s: %s", ex.getMessage(), ex.getCause());
        }
        return responseEntity;
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<ProjectWorkerResponseDTO> updateProjectWorker(@PathVariable("id") Long employeeId, @RequestBody ProjectWorkerRequestDTO projectWorkerRequestDTO)
    {
        ResponseEntity<ProjectWorkerResponseDTO> responseEntity = ResponseEntity.badRequest().build();

        try {
            responseEntity = ResponseEntity.ok(       projectWorkerService.updateProjectWorker(employeeId, projectWorkerRequestDTO));

        } catch (Throwable ex) {
            System.out.printf("%s: %s", ex.getMessage(), ex.getCause());
        }
        return responseEntity;
    }

    @PostMapping("/delete/employeeId")
    public ResponseEntity<ProjectWorkerResponseDTO> deleteProjectWorker(@RequestParam("employeeId") Long employeeId)
    {
        ResponseEntity<ProjectWorkerResponseDTO> responseEntity = ResponseEntity.badRequest().build();

        try {
            responseEntity = ResponseEntity.ok(       projectWorkerService.deleteProjectWorkerByEmployeeId(employeeId));

        } catch (Throwable ex) {
            System.out.printf("%s: %s", ex.getMessage(), ex.getCause());
        }
        return responseEntity;
    }

    @GetMapping("/find/employeeId")
    public ResponseEntity<ProjectWorkerResponseDTO> findProjectWorkerByEmployeeId(@RequestParam("employeeId") Long employeeId)
    {
        ResponseEntity<ProjectWorkerResponseDTO> responseEntity = ResponseEntity.badRequest().build();

        try {
            responseEntity = ResponseEntity.ok(       projectWorkerService.findProjectWorkerByEmployeeId(employeeId));

        } catch (Throwable ex) {
            System.out.printf("%s: %s", ex.getMessage(), ex.getCause());
        }
        return responseEntity;
    }

    @GetMapping("/all")
    public ResponseEntity<List<ProjectWorkerResponseDTO>> findAllProjectWorkers()
    {
        ResponseEntity<List<ProjectWorkerResponseDTO>> responseEntity = ResponseEntity.badRequest().build();

        try {
            responseEntity = ResponseEntity.ok(       projectWorkerService.findAllProjectWorkers());

        } catch (Throwable ex) {
            System.out.printf("%s: %s", ex.getMessage(), ex.getCause());
        }
        return responseEntity;
    }
}
