package com.sengulkaya.app.service.rest.payrollmanagement.data.entity.employee;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Departments")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "department_id")
    private long departmentId;

    @Column(name = "department_name")
    @NotNull
    private String departmentName;

    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @OrderColumn
    @Column(name = "employees", nullable = false)
    @ElementCollection(targetClass=Employee.class)
    private Set<Employee> employees = new HashSet<>();

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(long departmentId) {
        this.departmentId = departmentId;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }
}
