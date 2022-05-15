package com.sengulkaya.app.service.rest.payrollmanagement.controller;


import com.sengulkaya.app.service.rest.payrollmanagement.dto.requestDTO.SalesManagerRequestDTO;
import com.sengulkaya.app.service.rest.payrollmanagement.dto.responseDTO.ProjectWorkerResponseDTO;
import com.sengulkaya.app.service.rest.payrollmanagement.dto.responseDTO.SalesManagerResponseDTO;
import com.sengulkaya.app.service.rest.payrollmanagement.service.SalesManagerService;
import org.springframework.context.annotation.Scope;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<SalesManagerResponseDTO> saveSalesManager(@RequestBody SalesManagerRequestDTO salesManagerRequestDTO)
    {
        ResponseEntity<SalesManagerResponseDTO> responseEntity = ResponseEntity.badRequest().build();

        try {
            responseEntity = ResponseEntity.ok(       salesManagerService.saveSalesManager(salesManagerRequestDTO));

        } catch (Throwable ex) {
            System.out.printf("%s: %s", ex.getMessage(), ex.getCause());
        }
        return responseEntity;
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<SalesManagerResponseDTO> updateSalesManager(@PathVariable("id") Long employeeId, @RequestBody SalesManagerRequestDTO salesManagerRequestDTO)
    {
        ResponseEntity<SalesManagerResponseDTO> responseEntity = ResponseEntity.badRequest().build();

        try {
            responseEntity = ResponseEntity.ok(       salesManagerService.updateSalesManager(employeeId, salesManagerRequestDTO));

        } catch (Throwable ex) {
            System.out.printf("%s: %s", ex.getMessage(), ex.getCause());
        }
        return responseEntity;
    }


    @PostMapping("/delete/employeeId")
    public ResponseEntity<SalesManagerResponseDTO> deleteSalesManager(@RequestParam("employeeId") Long employeeId)
    {
        ResponseEntity<SalesManagerResponseDTO> responseEntity = ResponseEntity.badRequest().build();

        try {
            responseEntity = ResponseEntity.ok(       salesManagerService.deleteSalesManagerByEmployeeId(employeeId));

        } catch (Throwable ex) {
            System.out.printf("%s: %s", ex.getMessage(), ex.getCause());
        }
        return responseEntity;
    }
    @GetMapping("/find/employeeId")
    public ResponseEntity<SalesManagerResponseDTO> findSalesManagerByEmployeeId(@RequestParam("employeeId") Long employeeId)
    {
        ResponseEntity<SalesManagerResponseDTO> responseEntity = ResponseEntity.badRequest().build();

        try {
            responseEntity = ResponseEntity.ok(       salesManagerService.findSalesManagerByEmployeeId(employeeId));

        } catch (Throwable ex) {
            System.out.printf("%s: %s", ex.getMessage(), ex.getCause());
        }
        return responseEntity;
    }

    @GetMapping("/all")
    public ResponseEntity<List<SalesManagerResponseDTO>> findAllSalesManagers()
    {
        ResponseEntity<List<SalesManagerResponseDTO>> responseEntity = ResponseEntity.badRequest().build();

        try {
            responseEntity = ResponseEntity.ok(       salesManagerService.findAllSalesManagers());

        } catch (Throwable ex) {
            System.out.printf("%s: %s", ex.getMessage(), ex.getCause());
        }
        return responseEntity;
    }
}
