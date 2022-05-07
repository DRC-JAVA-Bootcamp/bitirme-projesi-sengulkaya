package com.sengulkaya.app.service.rest.payrollmanagement.data.repository;

import com.sengulkaya.app.service.rest.payrollmanagement.data.entity.employee.ProjectWorker;
import com.sengulkaya.app.service.rest.payrollmanagement.data.entity.employee.Worker;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface IProjectWorkerRepository extends CrudRepository<ProjectWorker, Long> {
    Optional<ProjectWorker> findByCitizenId(String citizenId);
}
