package com.sengulkaya.app.service.rest.payrollmanagement.service;

import com.sengulkaya.app.service.rest.payrollmanagement.data.dal.ServiceDAL;
import com.sengulkaya.app.service.rest.payrollmanagement.data.entity.employee.Department;
import com.sengulkaya.app.service.rest.payrollmanagement.data.entity.employee.Employee;
import com.sengulkaya.app.service.rest.payrollmanagement.data.entity.employee.Worker;
import com.sengulkaya.app.service.rest.payrollmanagement.dto.exception.repository.RepositoryException;
import com.sengulkaya.app.service.rest.payrollmanagement.dto.exception.service.WorkerServiceException;
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
       try {

           Department department = serviceDAL.findDepartmentById(workerRequestDTO.getDepartmentId());
           Worker worker = serviceDAL.saveWorker(workerMapper.toWorker(workerRequestDTO));
           department.getEmployees().add(worker);
           worker.setDepartment(serviceDAL.saveDepartment(department));

           return workerMapper.toWorkerResponseDTO(worker);

       } catch (RepositoryException ex) {

           System.out.printf("%s: %s", ex.getMessage(), ex.getCause());
           throw new WorkerServiceException("WorkerService.saveWorker", ex.getCause());

       } catch (Throwable ex) {

           throw new WorkerServiceException("WorkerService.saveWorker", ex);
       }
   }

    @Transactional
    public WorkerResponseDTO updateWorker(Long employeeId, WorkerRequestDTO workerRequestDTO)
    {
        try {

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
        } catch (RepositoryException ex) {

            System.out.printf("%s: %s", ex.getMessage(), ex.getCause());
            throw new WorkerServiceException("WorkerService.updateWorker", ex.getCause());

        } catch (Throwable ex) {

            throw new WorkerServiceException("WorkerService.updateWorker", ex);
        }
    }

    @Transactional
    public WorkerResponseDTO deleteWorkerByEmployeeId(Long employeeId)
    {
        try {

            Worker worker = serviceDAL.findWorkerByEmployeeId(employeeId);
            Department department = worker.getDepartment();
            Set<Employee> set = department.getEmployees();
            set.remove(worker);

            serviceDAL.saveDepartment(department);
            return workerMapper.toWorkerResponseDTO
                    (serviceDAL.removeWorker(worker));

        } catch (RepositoryException ex) {

            System.out.printf("%s: %s", ex.getMessage(), ex.getCause());
            throw new WorkerServiceException("WorkerService.deleteWorkerByEmployeeId", ex.getCause());

        } catch (Throwable ex) {

            throw new WorkerServiceException("WorkerService.deleteWorkerByEmployeeId", ex);
        }
    }

    public WorkerResponseDTO findWorkerByEmployeeId(Long employeeId)
    {
        try {

            return workerMapper.toWorkerResponseDTO(serviceDAL.findWorkerByEmployeeId(employeeId));

        } catch (RepositoryException ex) {

            System.out.printf("%s: %s", ex.getMessage(), ex.getCause());
            throw new WorkerServiceException("WorkerService.findWorkerByEmployeeId", ex.getCause());

        } catch (Throwable ex) {

            throw new WorkerServiceException("WorkerService.findWorkerByEmployeeId", ex);
        }
    }

    public List<WorkerResponseDTO> findAllWorkers()
    {
        try {

            return serviceDAL.findAllWorkers().stream()
                    .map(workerMapper::toWorkerResponseDTO)
                    .collect(Collectors.toList());

        } catch (RepositoryException ex) {

            System.out.printf("%s: %s", ex.getMessage(), ex.getCause());
            throw new WorkerServiceException("WorkerService.findAllWorkers", ex.getCause());

        } catch (Throwable ex) {

            throw new WorkerServiceException("WorkerService.findAllWorkers", ex);
        }
    }
}
