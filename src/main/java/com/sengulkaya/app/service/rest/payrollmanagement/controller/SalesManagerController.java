package com.sengulkaya.app.service.rest.payrollmanagement.controller;


import com.sengulkaya.app.service.rest.payrollmanagement.dto.requestDTO.ManagerRequestDTO;
import com.sengulkaya.app.service.rest.payrollmanagement.dto.requestDTO.SalesManagerRequestDTO;
import com.sengulkaya.app.service.rest.payrollmanagement.dto.responseDTO.ManagerResponseDTO;
import com.sengulkaya.app.service.rest.payrollmanagement.dto.responseDTO.SalesManagerResponseDTO;
import com.sengulkaya.app.service.rest.payrollmanagement.service.ManagerService;
import com.sengulkaya.app.service.rest.payrollmanagement.service.SalesManagerService;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/salesManager")
@Scope("prototype")
public class SalesManagerController {
    private final SalesManagerService salesManagerService;

    public SalesManagerController(SalesManagerService salesManagerService)
    {
        this.salesManagerService = salesManagerService;
    }

    @PostMapping("/save")
    public SalesManagerResponseDTO saveWorker(SalesManagerRequestDTO salesManagerRequestDTO)
    {
        return salesManagerService.saveSalesManager(salesManagerRequestDTO);
    }
}
