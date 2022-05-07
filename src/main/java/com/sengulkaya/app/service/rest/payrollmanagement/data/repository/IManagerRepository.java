package com.sengulkaya.app.service.rest.payrollmanagement.data.repository;

import com.sengulkaya.app.service.rest.payrollmanagement.data.entity.employee.Manager;
import com.sengulkaya.app.service.rest.payrollmanagement.data.entity.employee.Worker;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface IManagerRepository extends CrudRepository<Manager, Long> {
    Optional<Manager> findByCitizenId(String citizenId);
}
