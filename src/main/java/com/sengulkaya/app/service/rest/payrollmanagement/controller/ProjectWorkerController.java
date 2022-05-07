package com.sengulkaya.app.service.rest.payrollmanagement.controller;

import com.sengulkaya.app.service.rest.payrollmanagement.dto.requestDTO.ProjectWorkerRequestDTO;
import com.sengulkaya.app.service.rest.payrollmanagement.dto.responseDTO.ProjectWorkerResponseDTO;
import com.sengulkaya.app.service.rest.payrollmanagement.service.ProjectWorkerService;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public ProjectWorkerResponseDTO saveProjectWorker(ProjectWorkerRequestDTO projectWorkerRequestDTO)
    {
        return projectWorkerService.saveProjectWorker(projectWorkerRequestDTO);
    }

}
