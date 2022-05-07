package com.sengulkaya.app.service.rest.payrollmanagement.service;

import com.sengulkaya.app.service.rest.payrollmanagement.data.dal.ServiceDAL;
import com.sengulkaya.app.service.rest.payrollmanagement.data.entity.employee.ProjectWorker;
import com.sengulkaya.app.service.rest.payrollmanagement.data.repository.IProjectWorkerRepository;
import com.sengulkaya.app.service.rest.payrollmanagement.dto.requestDTO.ProjectWorkerRequestDTO;
import com.sengulkaya.app.service.rest.payrollmanagement.dto.requestDTO.WorkerRequestDTO;
import com.sengulkaya.app.service.rest.payrollmanagement.dto.responseDTO.ProjectWorkerResponseDTO;
import com.sengulkaya.app.service.rest.payrollmanagement.dto.responseDTO.WorkerResponseDTO;
import com.sengulkaya.app.service.rest.payrollmanagement.mapper.IProectWorkerMapper;
import com.sengulkaya.app.service.rest.payrollmanagement.mapper.IProjectWorkerMapper;
import com.sengulkaya.app.service.rest.payrollmanagement.mapper.ProjectWorkerMapperImpl;

import java.util.List;

public class ProjectWorkerService  {
    private final ServiceDAL serviceDAL;
    private final IProjectWorkerMapper projectWorkerMapper;

    public ProjectWorkerService(ServiceDAL serviceDAL,
                                IProjectWorkerMapper projectWorkerMapper)
    {
        this.serviceDAL = serviceDAL;
        this.projectWorkerMapper = projectWorkerMapper;
    }

    public ProjectWorkerResponseDTO saveProjectWorker(ProjectWorkerRequestDTO projectWorkerRequestDTO)
    {
        return projectWorkerMapper.toProjectWorkerResponseDTO
                (serviceDAL.saveProjectWorker(projectWorkerMapper.toProjectWorker(projectWorkerRequestDTO)));
    }

    public ProjectWorkerResponseDTO updateProjectWorker(ProjectWorkerRequestDTO projectWorkerRequestDTO)
    {
        //
    }

    public ProjectWorkerResponseDTO removeProjectWorkerById(Long projectWorkerId)
    {

    }

    public List<ProjectWorkerResponseDTO> findAllProjectWorkers()
    {

    }

}
