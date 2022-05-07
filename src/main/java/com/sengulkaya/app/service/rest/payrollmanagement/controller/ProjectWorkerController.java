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

    @PostMapping("/update")
    public ProjectWorkerResponseDTO updateProjectWorker(@RequestBody ProjectWorkerRequestDTO projectWorkerRequestDTO)
    {
        return projectWorkerService.updateProjectWorker(projectWorkerRequestDTO);
    }

    @PostMapping("/delete")
    public ProjectWorkerResponseDTO deleteprojectWorker(@RequestParam("citizenId") String citizenId)
    {
        return projectWorkerService.deleteProjectWorkerByCitizenId(citizenId);
    }
    @GetMapping("/find/citizenId")
    public ProjectWorkerResponseDTO findProjectWorkerByCitizenId(@RequestParam("citizenId") String citizenId)
    {
        return projectWorkerService.findProjectWorkerByCitizenId(citizenId);
    }

    @GetMapping("/all")
    public List<ProjectWorkerResponseDTO> findAllProjectWorkers()
    {
        return projectWorkerService.findAllProjectWorkers();
    }

}
