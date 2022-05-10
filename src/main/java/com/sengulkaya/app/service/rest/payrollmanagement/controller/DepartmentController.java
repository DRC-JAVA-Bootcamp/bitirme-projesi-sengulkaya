package com.sengulkaya.app.service.rest.payrollmanagement.controller;


import com.sengulkaya.app.service.rest.payrollmanagement.dto.requestDTO.DepartmentRequestDTO;
import com.sengulkaya.app.service.rest.payrollmanagement.dto.requestDTO.ManagerRequestDTO;
import com.sengulkaya.app.service.rest.payrollmanagement.dto.responseDTO.DepartmentResponseDTO;
import com.sengulkaya.app.service.rest.payrollmanagement.dto.responseDTO.ManagerResponseDTO;
import com.sengulkaya.app.service.rest.payrollmanagement.service.DepartmentService;
import com.sengulkaya.app.service.rest.payrollmanagement.service.ManagerService;
import org.springframework.context.annotation.Scope;
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

    @PostMapping("/save")//works
    public DepartmentResponseDTO saveDepartment(@RequestBody DepartmentRequestDTO departmentRequestDTO)
    {
        return departmentService.saveDepartment(departmentRequestDTO);
    }

    @PostMapping("/update/{id}")
    public DepartmentResponseDTO updateDepartment(@PathVariable("id") Long departmentId, @RequestBody DepartmentRequestDTO departmentRequestDTO)
    {
        return departmentService.updateDepartment(departmentId, departmentRequestDTO);
    }


    @GetMapping("/find/{id}")//works
    public DepartmentResponseDTO findDepartmentBId(@PathVariable("id") Long departmentId)
    {
        return departmentService.findDepartmentById(departmentId);
    }

    //http://localhost:8082/api/department/find/all
    @GetMapping("/find/all")//works
    public List<DepartmentResponseDTO> findAllDepartments()
    {
        return departmentService.findAllDepartments();
    }
}
