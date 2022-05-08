package com.sengulkaya.app.service.rest.payrollmanagement.data.repository;

import com.sengulkaya.app.service.rest.payrollmanagement.data.entity.employee.Department;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface IDepartmentRepository extends CrudRepository<Department, Long> {
    @Query(value = "select department from Departments department where department.departmentName = :departmentName", nativeQuery = true)
    Optional<Department> findByName(String departmentName);
}
