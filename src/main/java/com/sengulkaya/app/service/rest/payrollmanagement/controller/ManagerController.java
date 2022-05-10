package com.sengulkaya.app.service.rest.payrollmanagement.controller;


import com.sengulkaya.app.service.rest.payrollmanagement.dto.requestDTO.ManagerRequestDTO;
import com.sengulkaya.app.service.rest.payrollmanagement.dto.responseDTO.ManagerResponseDTO;
import com.sengulkaya.app.service.rest.payrollmanagement.service.ManagerService;
import org.springframework.context.annotation.Scope;
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

    @PostMapping("/save")//works
    public ManagerResponseDTO saveManager(@RequestBody ManagerRequestDTO managerRequestDTO)
    {
        return managerService.saveManager(managerRequestDTO);
    }
    @PostMapping("/update/{id}")//works
    public ManagerResponseDTO updateManager(@PathVariable("id") Long employeeId, @RequestBody ManagerRequestDTO managerRequestDTO)
    {
        return managerService.updateManager(employeeId, managerRequestDTO);
    }


    @PostMapping("/delete/employeeId")//works, java.util.NoSuchElementException: No value present
    public ManagerResponseDTO deleteManager(@RequestParam("employeeId") Long employeeId)
    {
        return managerService.deleteManagerByEmployeeId(employeeId);
    }
    @GetMapping("/find/employeeId")//works
    public ManagerResponseDTO findManagerByCitizenId(@RequestParam("employeeId") Long employeeId)
    {
        return managerService.findManagerByEmployeeId(employeeId);
    }

    @GetMapping("/all")//works
    public List<ManagerResponseDTO> findAllManagers()
    {
        return managerService.findAllManagers();
    }
}
