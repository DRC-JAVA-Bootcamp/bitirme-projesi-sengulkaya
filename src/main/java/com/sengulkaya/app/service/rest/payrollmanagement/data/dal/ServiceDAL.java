package com.sengulkaya.app.service.rest.payrollmanagement.data.dal;

import com.sengulkaya.app.service.rest.payrollmanagement.data.entity.employee.*;
import com.sengulkaya.app.service.rest.payrollmanagement.data.repository.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Iterator;
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
        return workerRepository.save(worker);
    }

    public ProjectWorker saveProjectWorker(ProjectWorker projectWorker) {
        return workerRepository.save(projectWorker);
    }

    public Manager saveManager(Manager manager) {
        return managerRepository.save(manager);
    }

    public SalesManager saveSalesManager(SalesManager salesManager) {
        return salesManagerRepository.save(salesManager);
    }

    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    public Worker findWorkerByEmployeeId(Long employeeId) {
        return workerRepository.findByEmployeeId(employeeId).get();
    }

    public ProjectWorker findProjectWorkerByEmployeeId(Long employeeId) {
        return projectWorkerRepository.findByEmployeeId(employeeId).get();
    }

    public Manager findManagerByEmployeeId(Long employeeId) {
        return managerRepository.findByEmployeeId(employeeId).get();
    }

    public SalesManager findSalesManagerByEmployeeId(Long employeeId) {
        return salesManagerRepository.findByEmployeeId(employeeId).get();
    }

    public Department findDepartmentById(Long departmentId) {
        return departmentRepository.findById(departmentId).get();
    }
    /*public Department findDepartmentByName(String departmentName) {
        return departmentRepository.findByName(departmentName).get();
    }*/


    public Worker removeWorker(Worker worker) {
        workerRepository.delete(worker);
        return worker;
    }

    public ProjectWorker removeProjectWorker(ProjectWorker projectWorker) {
        projectWorkerRepository.delete(projectWorker);
        return projectWorker;
    }

    public Manager removeManager(Manager manager) {
        managerRepository.delete(manager);
        return manager;
    }

    public SalesManager removeSalesManager(SalesManager salesManager) {
        salesManagerRepository.delete(salesManager);
        return salesManager;
    }


    public List<Worker> findAllWorkers() {
        return StreamSupport.stream(workerRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    public List<ProjectWorker> findAllProjectWorkers() {
        return StreamSupport.stream(projectWorkerRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    public List<Manager> findAllManagers() {
        return StreamSupport.stream(managerRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    public List<SalesManager> findAllSalesManagers() {
        return StreamSupport.stream(salesManagerRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    public List<Department> findAllDepartments() {
        return StreamSupport.stream(departmentRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    public List<Employee> findAllEmployees()
    {

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
    }
}
