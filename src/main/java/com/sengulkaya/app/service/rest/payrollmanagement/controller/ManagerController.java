package com.sengulkaya.app.service.rest.payrollmanagement.controller;


import com.sengulkaya.app.service.rest.payrollmanagement.dto.requestDTO.ManagerRequestDTO;
import com.sengulkaya.app.service.rest.payrollmanagement.dto.responseDTO.DepartmentResponseDTO;
import com.sengulkaya.app.service.rest.payrollmanagement.dto.responseDTO.ManagerResponseDTO;
import com.sengulkaya.app.service.rest.payrollmanagement.service.ManagerService;
import org.springframework.context.annotation.Scope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/manager")
@Scope("prototype")
public class ManagerController {
    private final ManagerService managerService;

    public ManagerController(ManagerService managerService)
    {
        this.managerService = managerService;
    }

    @PostMapping("/save")//work
    public ResponseEntity<ManagerResponseDTO> saveManager(@RequestBody ManagerRequestDTO managerRequestDTO)
    {
        ResponseEntity<ManagerResponseDTO> responseEntity = ResponseEntity.badRequest().build();

        try {
            responseEntity = ResponseEntity.ok(       managerService.saveManager(managerRequestDTO));

        } catch (Throwable ex) {
            System.out.printf("%s: %s", ex.getMessage(), ex.getCause());
        }
        return responseEntity;
    }
    @PostMapping("/update/{id}")
    public ResponseEntity<ManagerResponseDTO> updateManager(@PathVariable("id") Long employeeId, @RequestBody ManagerRequestDTO managerRequestDTO)
    {
        ResponseEntity<ManagerResponseDTO> responseEntity = ResponseEntity.badRequest().build();

        try {
            responseEntity = ResponseEntity.ok(       managerService.updateManager(employeeId, managerRequestDTO));

        } catch (Throwable ex) {
            System.out.printf("%s: %s", ex.getMessage(), ex.getCause());
        }
        return responseEntity;
    }


    @PostMapping("/delete/employeeId")//throws java.util.NoSuchElementException: No value present
    public ResponseEntity<ManagerResponseDTO> deleteManager(@RequestParam("employeeId") Long employeeId)
    {
        ResponseEntity<ManagerResponseDTO> responseEntity = ResponseEntity.badRequest().build();

        try {
            responseEntity = ResponseEntity.ok(       managerService.deleteManagerByEmployeeId(employeeId));

        } catch (Throwable ex) {
            System.out.printf("%s: %s", ex.getMessage(), ex.getCause());
        }
        return responseEntity;
    }
    @GetMapping("/find/employeeId")
    public ResponseEntity<ManagerResponseDTO> findManagerByCitizenId(@RequestParam("employeeId") Long employeeId)
    {
        ResponseEntity<ManagerResponseDTO> responseEntity = ResponseEntity.badRequest().build();

        try {
            responseEntity = ResponseEntity.ok(       managerService.findManagerByEmployeeId(employeeId));

        } catch (Throwable ex) {
            System.out.printf("%s: %s", ex.getMessage(), ex.getCause());
        }
        return responseEntity;
    }

    @GetMapping("/all")
    public ResponseEntity<List<ManagerResponseDTO>> findAllManagers()
    {
        ResponseEntity<List<ManagerResponseDTO>> responseEntity = ResponseEntity.badRequest().build();

        try {
            responseEntity = ResponseEntity.ok(       managerService.findAllManagers());

        } catch (Throwable ex) {
            System.out.printf("%s: %s", ex.getMessage(), ex.getCause());
        }
        return responseEntity;
    }
}
