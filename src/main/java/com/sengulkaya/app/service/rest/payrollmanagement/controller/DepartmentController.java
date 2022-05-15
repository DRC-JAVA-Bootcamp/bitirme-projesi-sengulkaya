package com.sengulkaya.app.service.rest.payrollmanagement.controller;


import com.sengulkaya.app.service.rest.payrollmanagement.dto.requestDTO.DepartmentRequestDTO;
import com.sengulkaya.app.service.rest.payrollmanagement.dto.requestDTO.ManagerRequestDTO;
import com.sengulkaya.app.service.rest.payrollmanagement.dto.responseDTO.DepartmentResponseDTO;
import com.sengulkaya.app.service.rest.payrollmanagement.dto.responseDTO.ManagerResponseDTO;
import com.sengulkaya.app.service.rest.payrollmanagement.service.DepartmentService;
import com.sengulkaya.app.service.rest.payrollmanagement.service.ManagerService;
import org.springframework.context.annotation.Scope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/department")
@Scope("prototype")
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService)
    {
        this.departmentService = departmentService;
    }

    @PostMapping("/save")
    public ResponseEntity<DepartmentResponseDTO> saveDepartment(@RequestBody DepartmentRequestDTO departmentRequestDTO)
    {
        ResponseEntity<DepartmentResponseDTO> responseEntity = ResponseEntity.badRequest().build();

        try {
            responseEntity = ResponseEntity.ok(       departmentService.saveDepartment(departmentRequestDTO));

        } catch (Throwable ex) {
            System.out.printf("%s: %s", ex.getMessage(), ex.getCause());
        }
        return responseEntity;
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<DepartmentResponseDTO> updateDepartment(@PathVariable("id") Long departmentId, @RequestBody DepartmentRequestDTO departmentRequestDTO)
    {
        ResponseEntity<DepartmentResponseDTO> responseEntity = ResponseEntity.badRequest().build();

        try {
            responseEntity = ResponseEntity.ok(       departmentService.updateDepartment(departmentId, departmentRequestDTO));

        } catch (Throwable ex) {
            System.out.printf("%s: %s", ex.getMessage(), ex.getCause());
        }
        return responseEntity;
    }


    @GetMapping("/find/{id}")
    public ResponseEntity<DepartmentResponseDTO> findDepartmentBId(@PathVariable("id") Long departmentId)
    {
        ResponseEntity<DepartmentResponseDTO> responseEntity = ResponseEntity.badRequest().build();

        try {
            responseEntity = ResponseEntity.ok(       departmentService.findDepartmentById(departmentId));

        } catch (Throwable ex) {
            System.out.printf("%s: %s", ex.getMessage(), ex.getCause());
        }
        return responseEntity;
    }

    //http://localhost:8082/api/department/find/all
    @GetMapping("/find/all")
    public ResponseEntity<List<DepartmentResponseDTO>> findAllDepartments()
    {
        ResponseEntity<List<DepartmentResponseDTO>> responseEntity = ResponseEntity.badRequest().build();

        try {
            responseEntity = ResponseEntity.ok(       departmentService.findAllDepartments());

        } catch (Throwable ex) {
            System.out.printf("%s: %s", ex.getMessage(), ex.getCause());
        }
        return responseEntity;
    }
}
