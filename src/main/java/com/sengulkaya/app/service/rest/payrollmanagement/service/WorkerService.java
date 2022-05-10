package com.sengulkaya.app.service.rest.payrollmanagement.service;

import com.sengulkaya.app.service.rest.payrollmanagement.data.dal.ServiceDAL;
import com.sengulkaya.app.service.rest.payrollmanagement.data.entity.employee.Department;
import com.sengulkaya.app.service.rest.payrollmanagement.data.entity.employee.Employee;
import com.sengulkaya.app.service.rest.payrollmanagement.data.entity.employee.Manager;
import com.sengulkaya.app.service.rest.payrollmanagement.data.entity.employee.Worker;
import com.sengulkaya.app.service.rest.payrollmanagement.dto.requestDTO.WorkerRequestDTO;
import com.sengulkaya.app.service.rest.payrollmanagement.dto.responseDTO.WorkerResponseDTO;
import com.sengulkaya.app.service.rest.payrollmanagement.mapper.WorkerMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Transactional
   public WorkerResponseDTO saveWorker(WorkerRequestDTO workerRequestDTO)
   {
       Department department = serviceDAL.findDepartmentById(workerRequestDTO.getDepartmentId());
       Worker worker = serviceDAL.saveWorker(workerMapper.toWorker(workerRequestDTO));
       department.getEmployees().add(worker);
       worker.setDepartment(serviceDAL.saveDepartment(department));

       return workerMapper.toWorkerResponseDTO(worker);
   }

    @Transactional
    public WorkerResponseDTO updateWorker(Long employeeId, WorkerRequestDTO workerRequestDTO)
    {
        Worker found = serviceDAL.findWorkerByEmployeeId(employeeId);

        found.setCitizenId(workerRequestDTO.getCitizenId());
        found.setName(workerRequestDTO.getName());
        found.setDateOfBirth(workerRequestDTO.getDateOfBirth());
        found.setDepartment(serviceDAL.findDepartmentById(workerRequestDTO.getDepartmentId()));
        found.setJobTitle(workerRequestDTO.getJobTitle());
        found.setDateOfEmployment(workerRequestDTO.getDateOfEmployment());
        found.setBaseSalary(workerRequestDTO.getBaseSalary());
        found.setRatePerHour(workerRequestDTO.getRatePerHour());
        found.setActive(workerRequestDTO.isActive());

        return workerMapper.toWorkerResponseDTO(serviceDAL.saveWorker(found));
    }

    @Transactional
    public WorkerResponseDTO deleteWorkerByEmployeeId(Long employeeId)
    {
        Worker worker = serviceDAL.findWorkerByEmployeeId(employeeId);
        Department department = worker.getDepartment();
        Set<Employee> set = department.getEmployees();
        set.remove(worker);
        //worker.setEmployees(set);
        serviceDAL.saveDepartment(department);
        return workerMapper.toWorkerResponseDTO
                (serviceDAL.removeWorker(worker));
    }

    public WorkerResponseDTO findWorkerByEmployeeId(Long employeeId)
    {
        return workerMapper.toWorkerResponseDTO(serviceDAL.findWorkerByEmployeeId(employeeId));
    }

    public List<WorkerResponseDTO> findAllWorkers()
    {
        return serviceDAL.findAllWorkers().stream()
                .map(workerMapper::toWorkerResponseDTO)
                .collect(Collectors.toList());
    }
}
