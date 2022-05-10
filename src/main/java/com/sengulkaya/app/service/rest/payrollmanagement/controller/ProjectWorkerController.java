package com.sengulkaya.app.service.rest.payrollmanagement.controller;

import com.sengulkaya.app.service.rest.payrollmanagement.dto.requestDTO.ProjectWorkerRequestDTO;
import com.sengulkaya.app.service.rest.payrollmanagement.dto.responseDTO.ProjectWorkerResponseDTO;
import com.sengulkaya.app.service.rest.payrollmanagement.service.ProjectWorkerService;
import org.springframework.context.annotation.Scope;
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
    public ProjectWorkerResponseDTO saveProjectWorker(@RequestBody ProjectWorkerRequestDTO projectWorkerRequestDTO)
    {
        return projectWorkerService.saveProjectWorker(projectWorkerRequestDTO);
    }

    @PostMapping("/update/{id}")
    public ProjectWorkerResponseDTO updateProjectWorker(@PathVariable("id") Long employeeId, @RequestBody ProjectWorkerRequestDTO projectWorkerRequestDTO)
    {
        return projectWorkerService.updateProjectWorker(employeeId, projectWorkerRequestDTO);
    }

    @PostMapping("/delete")
    public ProjectWorkerResponseDTO deleteprojectWorker(@RequestParam("employeeId") Long employeeId)
    {
        return projectWorkerService.deleteProjectWorkerByEmployeeId(employeeId);
    }
    @GetMapping("/find/citizenId")
    public ProjectWorkerResponseDTO findProjectWorkerByEmployeeId(@RequestParam("employeeId") Long employeeId)
    {
        return projectWorkerService.findProjectWorkerByEmployeeId(employeeId);
    }

    @GetMapping("/all")
    public List<ProjectWorkerResponseDTO> findAllProjectWorkers()
    {
        return projectWorkerService.findAllProjectWorkers();
    }

}
