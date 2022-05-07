package com.sengulkaya.app.service.rest.payrollmanagement.controller;


import com.sengulkaya.app.service.rest.payrollmanagement.dto.requestDTO.ManagerRequestDTO;
import com.sengulkaya.app.service.rest.payrollmanagement.dto.requestDTO.WorkerRequestDTO;
import com.sengulkaya.app.service.rest.payrollmanagement.dto.responseDTO.ManagerResponseDTO;
import com.sengulkaya.app.service.rest.payrollmanagement.dto.responseDTO.WorkerResponseDTO;
import com.sengulkaya.app.service.rest.payrollmanagement.service.ManagerService;
import com.sengulkaya.app.service.rest.payrollmanagement.service.WorkerService;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/manager")
@Scope("prototype")
public class ManagerController {
    private final ManagerService managerService;

    public ManagerController(ManagerService managerService)
    {
        this.managerService = managerService;
    }

    @PostMapping("/save")
    public ManagerResponseDTO saveWorker(ManagerRequestDTO managerRequestDTO)
    {
        return managerService.saveManager(managerRequestDTO);
    }
}
