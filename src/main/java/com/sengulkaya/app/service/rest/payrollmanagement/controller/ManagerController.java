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

    @PostMapping("/save")
    public ManagerResponseDTO saveManager(@RequestBody ManagerRequestDTO managerRequestDTO)
    {
        return managerService.saveManager(managerRequestDTO);
    }
    @PostMapping("/update")
    public ManagerResponseDTO updateManager(@RequestBody ManagerRequestDTO managerRequestDTO)
    {
        return managerService.updateManager(managerRequestDTO);
    }

    @PostMapping("/delete")
    public ManagerResponseDTO deleteManager(@RequestParam("citizenId") String citizenId)
    {
        return managerService.deleteManagerByCitizenId(citizenId);
    }
    @GetMapping("/find/citizenId")
    public ManagerResponseDTO findManagerByCitizenId(@RequestParam("citizenId") String citizenId)
    {
        return managerService.findManagerByCitizenId(citizenId);
    }

    @GetMapping("/all")
    public List<ManagerResponseDTO> findAllManagers()
    {
        return managerService.findAllManagers();
    }
}
