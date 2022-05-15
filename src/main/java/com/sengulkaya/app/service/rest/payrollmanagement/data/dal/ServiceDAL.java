package com.sengulkaya.app.service.rest.payrollmanagement.data.dal;

import com.sengulkaya.app.service.rest.payrollmanagement.data.entity.employee.*;
import com.sengulkaya.app.service.rest.payrollmanagement.data.repository.*;
import com.sengulkaya.app.service.rest.payrollmanagement.dto.exception.callbackinterfaces.ISupplierCallback;
import com.sengulkaya.app.service.rest.payrollmanagement.dto.exception.repository.RepositoryException;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Component
public class ServiceDAL {
    private final IWorkerRepository workerRepository;
    private final IProjectWorkerRepository projectWorkerRepository;
    private final IManagerRepository managerRepository;
    private final ISalesManagerRepository salesManagerRepository;
    private final IDepartmentRepository departmentRepository;

    private static <R> R doWorkForRepository(ISupplierCallback<R> supplier, String msg)
    {
        try {
            return supplier.get();
        }
        catch (Throwable ex) {
            throw new RepositoryException(msg, ex);
        }
    }




    public ServiceDAL(IWorkerRepository workerRepository,
                      IProjectWorkerRepository projectWorkerRepository,
                      IManagerRepository managerRepository,
                      ISalesManagerRepository salesManagerRepository,
                      IDepartmentRepository departmentRepository
    ) {
        this.workerRepository = workerRepository;
        this.projectWorkerRepository = projectWorkerRepository;
        this.salesManagerRepository = salesManagerRepository;
        this.managerRepository = managerRepository;
        this.departmentRepository = departmentRepository;
    }


    public Worker saveWorker(Worker worker) {
        try {
            return workerRepository.save(worker);
        } catch (Throwable cause) {
            throw new RepositoryException("ServiceDAL.saveWorker", cause);
        }
    }

    public ProjectWorker saveProjectWorker(ProjectWorker projectWorker) {
        try {
            return workerRepository.save(projectWorker);
        } catch (Throwable cause) {
            throw new RepositoryException("ServiceDAL.saveProjectWorker", cause);
        }
    }

    public Manager saveManager(Manager manager) {
        try {
            return managerRepository.save(manager);
        } catch (Throwable cause) {
            throw new RepositoryException("ServiceDAL.saveManager", cause);
        }
    }

    public SalesManager saveSalesManager(SalesManager salesManager) {
        try {
            return salesManagerRepository.save(salesManager);
        } catch (Throwable cause) {
            throw new RepositoryException("ServiceDAL.saveSalesManager", cause);
        }
    }

    public Department saveDepartment(Department department) {
        try {
            return departmentRepository.save(department);
        } catch (Throwable cause) {
            throw new RepositoryException("ServiceDAL.saveDepartment", cause);
        }
    }

    public Worker findWorkerByEmployeeId(Long employeeId) {
        try {
            return workerRepository.findByEmployeeId(employeeId).get();
        } catch (Throwable cause) {
            throw new RepositoryException("ServiceDAL.findWorkerByEmployeeId", cause);
        }
    }

    public ProjectWorker findProjectWorkerByEmployeeId(Long employeeId) {
        try {
            return projectWorkerRepository.findByEmployeeId(employeeId).get();
        } catch (Throwable cause) {
            throw new RepositoryException("ServiceDAL.findProjectWorkerByEmployeeId", cause);
        }
    }

    public Manager findManagerByEmployeeId(Long employeeId) {
        try {
            return managerRepository.findByEmployeeId(employeeId).get();
        } catch (Throwable cause) {
            throw new RepositoryException("ServiceDAL.findManagerByEmployeeId", cause);
        }
    }

    public SalesManager findSalesManagerByEmployeeId(Long employeeId) {
        try {
            return salesManagerRepository.findByEmployeeId(employeeId).get();
        } catch (Throwable cause) {
            throw new RepositoryException("ServiceDAL.findSalesManagerByEmployeeId", cause);
        }
    }

    public Department findDepartmentById(Long departmentId) {
        try {
            return departmentRepository.findById(departmentId).get();
        } catch (Throwable cause) {
            throw new RepositoryException("ServiceDAL.findDepartmentById", cause);
        }
    }
    /*public Department findDepartmentByName(String departmentName) {
        return departmentRepository.findByName(departmentName).get();
    }*/


    public Worker removeWorker(Worker worker) {
        try {
            workerRepository.delete(worker);
            return worker;
        } catch (Throwable cause) {
            throw new RepositoryException("ServiceDAL.removeWorker", cause);
        }
    }

    public ProjectWorker removeProjectWorker(ProjectWorker projectWorker) {
        try {
            projectWorkerRepository.delete(projectWorker);
            return projectWorker;
        } catch (Throwable cause) {
            throw new RepositoryException("ServiceDAL.removeProjectWorker", cause);
        }
    }

    public Manager removeManager(Manager manager) {
        try {
            managerRepository.delete(manager);
            return manager;
        } catch (Throwable cause) {
            throw new RepositoryException("ServiceDAL.removeManager", cause);
        }
    }

    public SalesManager removeSalesManager(SalesManager salesManager) {
        try {
            salesManagerRepository.delete(salesManager);
            return salesManager;
        } catch (Throwable cause) {
            throw new RepositoryException("ServiceDAL.removeSalesManager", cause);
        }
    }


    public List<Worker> findAllWorkers() {
        try {
            return StreamSupport.stream(workerRepository.findAll().spliterator(), false)
                    .collect(Collectors.toList());
        } catch (Throwable cause) {
            throw new RepositoryException("ServiceDAL.findAllWorkers", cause);
        }
    }

    public List<ProjectWorker> findAllProjectWorkers() {
        try {
            return StreamSupport.stream(projectWorkerRepository.findAll().spliterator(), false)
                    .collect(Collectors.toList());
        } catch (Throwable cause) {
            throw new RepositoryException("ServiceDAL.findAllProjectWorkers", cause);
        }
    }

    public List<Manager> findAllManagers() {
        try {
            return StreamSupport.stream(managerRepository.findAll().spliterator(), false)
                    .collect(Collectors.toList());
        } catch (Throwable cause) {
            throw new RepositoryException("ServiceDAL.findAllManagers", cause);
        }
    }

    public List<SalesManager> findAllSalesManagers() {
        try {
            return StreamSupport.stream(salesManagerRepository.findAll().spliterator(), false)
                    .collect(Collectors.toList());
        } catch (Throwable cause) {
            throw new RepositoryException("ServiceDAL.findAllSalesManagers", cause);
        }
    }

    public List<Department> findAllDepartments() {
        try {
            return StreamSupport.stream(departmentRepository.findAll().spliterator(), false)
                    .collect(Collectors.toList());
        } catch (Throwable cause) {
            throw new RepositoryException("ServiceDAL.findAllDepartments", cause);
        }
    }

    public List<Employee> findAllEmployees()
    {
        try {
            List<Employee> list = StreamSupport.stream(managerRepository.findAll().spliterator(), false)
                    .collect(Collectors.toList());

            list.addAll(StreamSupport.stream(salesManagerRepository.findAll().spliterator(), false)
                    .collect(Collectors.toList()));

            list.addAll(StreamSupport.stream(workerRepository.findAll().spliterator(), false)
                    .collect(Collectors.toList()));

            list.addAll(StreamSupport.stream(projectWorkerRepository.findAll().spliterator(), false)
                    .collect(Collectors.toList()));

            for (var val : list)
                System.out.println(val.getClass());

            return list;
        } catch (Throwable cause) {
            throw new RepositoryException("ServiceDAL.findAllEmployees", cause);
        }
    }
}
