package com.sengulkaya.app.service.rest.payrollmanagement.service;

import com.sengulkaya.app.service.rest.payrollmanagement.data.dal.ServiceDAL;
import com.sengulkaya.app.service.rest.payrollmanagement.data.entity.employee.Department;
import com.sengulkaya.app.service.rest.payrollmanagement.data.entity.employee.Employee;
import com.sengulkaya.app.service.rest.payrollmanagement.data.entity.employee.Worker;
import com.sengulkaya.app.service.rest.payrollmanagement.dto.requestDTO.WorkerRequestDTO;
import com.sengulkaya.app.service.rest.payrollmanagement.dto.responseDTO.WorkerResponseDTO;
import com.sengulkaya.app.service.rest.payrollmanagement.mapper.WorkerMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class WorkerService {
    private final ServiceDAL serviceDAL;
    private final WorkerMapper workerMapper;

   public WorkerService(ServiceDAL serviceDAL,
                        WorkerMapper workerMapper)
   {
       this.serviceDAL = serviceDAL;
       this.workerMapper = workerMapper;
   }

   public WorkerResponseDTO saveWorker(WorkerRequestDTO workerRequestDTO)
   {
       return workerMapper.toWorkerResponseDTO(serviceDAL.saveWorker(workerMapper.toWorker(workerRequestDTO)));
   }

    public WorkerResponseDTO updateWorker(WorkerRequestDTO workerRequestDTO)
    {
        Worker found = serviceDAL.findWorkerById(workerRequestDTO.getCitizenId());

        found.setName(workerRequestDTO.getName());
        found.setDateOfBirth(workerRequestDTO.getDateOfBirth());
        found.setDepartment(serviceDAL.findDepartmentByName(workerRequestDTO.getDepartment()));
        found.setJobTitle(workerRequestDTO.getJobTitle());
        found.setDateOfEmployment(workerRequestDTO.getDateOfEmployment());
        found.setBaseSalary(workerRequestDTO.getBaseSalary());
        found.setRatePerHour(workerRequestDTO.getRatePerHour());
        found.setActive(workerRequestDTO.isActive());

        return workerMapper.toWorkerResponseDTO(serviceDAL.saveWorker(found));
    }

    public WorkerResponseDTO deleteWorkerById(String citizenId)
    {
        Worker worker = serviceDAL.findWorkerById(citizenId);
        Department department = worker.getDepartment();
        Set<Employee> set = department.getEmployees();
        set.remove(worker);
        //worker.setEmployees(set);
        serviceDAL.saveDepartment(department);
        return workerMapper.toWorkerResponseDTO
                (serviceDAL.removeWorker(worker));
    }

    public WorkerResponseDTO findWorkerByCitizenId(String citizenId)
    {
        return workerMapper.toWorkerResponseDTO(serviceDAL.findWorkerById(citizenId));
    }

    public List<WorkerResponseDTO> findAllWorkers()
    {
        return serviceDAL.findAllWorkers().stream()
                .map(workerMapper::toWorkerResponseDTO)
                .collect(Collectors.toList());
    }
}
