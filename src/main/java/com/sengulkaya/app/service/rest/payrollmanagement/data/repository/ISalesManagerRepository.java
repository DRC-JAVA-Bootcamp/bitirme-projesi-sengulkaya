package com.sengulkaya.app.service.rest.payrollmanagement.data.repository;

import com.sengulkaya.app.service.rest.payrollmanagement.data.entity.employee.ProjectWorker;
import com.sengulkaya.app.service.rest.payrollmanagement.data.entity.employee.SalesManager;
import com.sengulkaya.app.service.rest.payrollmanagement.data.entity.employee.Worker;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ISalesManagerRepository extends CrudRepository<SalesManager, Long> {
    Optional<SalesManager> findByEmployeeId(Long employeeId);
}
