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

    @PostMapping("/update")
    public SalesManagerResponseDTO updateManager(@RequestBody SalesManagerRequestDTO salesManagerRequestDTO)
    {
        return salesManagerService.updateSalesManager(salesManagerRequestDTO);
    }

    @PostMapping("/delete")
    public SalesManagerResponseDTO deleteSalesManager(@RequestParam("citizenId") String citizenId)
    {
        return salesManagerService.deleteSalesManagerById(citizenId);
    }
    @GetMapping("/find/citizenId")
    public SalesManagerResponseDTO findSalesManagerByCitizenId(@RequestParam("citizenId") String citizenId)
    {
        return salesManagerService.findSalesManagerByCitizenId(citizenId);
    }

    @GetMapping("/all")
    public List<SalesManagerResponseDTO> findAllSalesManagers()
    {
        return salesManagerService.findAllSalesManagers();
    }
}
