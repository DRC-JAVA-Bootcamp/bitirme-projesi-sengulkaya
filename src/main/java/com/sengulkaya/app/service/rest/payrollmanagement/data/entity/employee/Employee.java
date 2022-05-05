package com.sengulkaya.app.service.rest.payrollmanagement.data.entity.employee;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.sengulkaya.app.service.rest.payrollmanagement.data.entity.employee.contracts.ILifeInsurance;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Employees")
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "jobTitle")
@JsonSubTypes({
        @JsonSubTypes.Type(value=Worker.class, name = "Worker"),
        @JsonSubTypes.Type(value=Worker.class, name = "Manager")
})
public abstract class Employee implements ILifeInsurance {
    @Id
    @Column(name = "citizen_id")
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private String citizenId;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "date_of_birth", nullable = false)
    private LocalDate dateOfBirth;//Retirement benefits?

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id")
    //@Column(name = "department", nullable = false)
    private Department department;

    @Transient
    private long departmantId;

    @Column(name = "job_title", nullable = false)
    private String jobTitle;

    @Column(name = "date_of_employment", nullable = false)
    private LocalDate dateOfEmployment;

    @Column(name = "date_of_leave", nullable = false)
    private LocalDate dateOfLeave;

    @Column(name = "base_salary", nullable = false)
    private double baseSalary;

    @Column(name = "overtime", nullable = false)
    private int overtime;

    @Column(name = "rate_per_hour", nullable = false)
    private double ratePerHour;

    public String getCitizenId() {
        return citizenId;
    }

    public void setCitizenId(String citizenId) {
        this.citizenId = citizenId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
    public long getDepartmantId() {
        return departmantId;
    }

    public void setDepartmantId(long departmantId) {
        this.departmantId = departmantId;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public LocalDate getDateOfEmployment() {
        return dateOfEmployment;
    }

    public void setDateOfEmployment(LocalDate dateOfEmployment) {
        this.dateOfEmployment = dateOfEmployment;
    }

    public LocalDate getDateOfLeave() {
        return dateOfLeave;
    }

    public void setDateOfLeave(LocalDate dateOfLeave) {
        this.dateOfLeave = dateOfLeave;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public int getOvertime() {
        return overtime;
    }

    public void setOvertime(int overtime) {
        this.overtime = overtime;
    }

    public double getRatePerHour() {
        return ratePerHour;
    }

    public void setRatePerHour(double ratePerHour) {
        this.ratePerHour = ratePerHour;
    }
}
