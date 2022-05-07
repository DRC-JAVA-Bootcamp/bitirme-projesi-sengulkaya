package com.sengulkaya.app.service.rest.payrollmanagement.data.repository;

import com.sengulkaya.app.service.rest.payrollmanagement.data.entity.employee.Department;
import org.springframework.data.repository.CrudRepository;

public interface IDepartmentRepository extends CrudRepository<Department, Long> {

}
