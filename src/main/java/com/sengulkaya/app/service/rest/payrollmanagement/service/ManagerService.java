package com.sengulkaya.app.service.rest.payrollmanagement.service;

import com.sengulkaya.app.service.rest.payrollmanagement.data.dal.ServiceDAL;
import com.sengulkaya.app.service.rest.payrollmanagement.dto.requestDTO.ManagerRequestDTO;
import com.sengulkaya.app.service.rest.payrollmanagement.dto.requestDTO.ProjectWorkerRequestDTO;
import com.sengulkaya.app.service.rest.payrollmanagement.dto.responseDTO.ManagerResponseDTO;
import com.sengulkaya.app.service.rest.payrollmanagement.dto.responseDTO.ProjectWorkerResponseDTO;
import com.sengulkaya.app.service.rest.payrollmanagement.mapper.IManagerMapper;
import com.sengulkaya.app.service.rest.payrollmanagement.mapper.IProjectWorkerMapper;

import java.util.List;

public class ManagerService {
    private final ServiceDAL serviceDAL;
    private final IManagerMapper managerMapper;

    public ManagerService(ServiceDAL serviceDAL,
                          IManagerMapper managerMapper)
    {
        this.serviceDAL = serviceDAL;
        this.managerMapper = managerMapper;
    }

    public ManagerResponseDTO saveManager(ManagerRequestDTO managerRequestDTO)
    {
        return managerMapper.toManagerResponseDTO
                (serviceDAL.saveManager(managerMapper.toManager(managerRequestDTO)));
    }

    public ManagerResponseDTO updateManager(ManagerRequestDTO managerRequestDTO)
    {
        //
    }

    public ManagerResponseDTO removeManagerById(Long managerId)
    {

    }

    public List<ManagerResponseDTO> findAllManagers()
    {

    }

}
