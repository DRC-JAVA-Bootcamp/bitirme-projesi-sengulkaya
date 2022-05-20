package com.sengulkaya.app.service.rest.payrollmanagement.data.repository;

import com.sengulkaya.app.service.rest.payrollmanagement.data.entity.employee.Manager;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface IManagerRepository extends CrudRepository<Manager, Long> {
    Optional<Manager> findByEmployeeId(Long employeeId);
}
