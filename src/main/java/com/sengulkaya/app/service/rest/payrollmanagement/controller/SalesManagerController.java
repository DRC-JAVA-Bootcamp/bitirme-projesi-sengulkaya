package com.sengulkaya.app.service.rest.payrollmanagement.controller;


import com.sengulkaya.app.service.rest.payrollmanagement.dto.requestDTO.SalesManagerRequestDTO;
import com.sengulkaya.app.service.rest.payrollmanagement.dto.responseDTO.SalesManagerResponseDTO;
import com.sengulkaya.app.service.rest.payrollmanagement.service.SalesManagerService;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public SalesManagerResponseDTO saveSalesManager(@RequestParam SalesManagerRequestDTO salesManagerRequestDTO)
    {
        return salesManagerService.saveSalesManager(salesManagerRequestDTO);
    }

    @PostMapping("/update/{id}")
    public SalesManagerResponseDTO updateManager(@PathVariable("id") Long employeeId, @RequestBody SalesManagerRequestDTO salesManagerRequestDTO)
    {
        return salesManagerService.updateSalesManager(employeeId, salesManagerRequestDTO);
    }

    @PostMapping("/delete")
    public SalesManagerResponseDTO deleteSalesManager(@RequestParam("employeeId") Long employeeId)
    {
        return salesManagerService.deleteSalesManagerByEmployeeId(employeeId);
    }
    @GetMapping("/find/citizenId")
    public SalesManagerResponseDTO findSalesManagerByEmployeeId(@RequestParam("employeeId") Long employeeId)
    {
        return salesManagerService.findSalesManagerByEmployeeId(employeeId);
    }

    @GetMapping("/all")
    public List<SalesManagerResponseDTO> findAllSalesManagers()
    {
        return salesManagerService.findAllSalesManagers();
    }
}
