package com.sengulkaya.app.service.rest.payrollmanagement.dto.requestDTO;

import com.sengulkaya.app.service.rest.payrollmanagement.data.entity.employee.Department;
import org.springframework.stereotype.Component;

import java.time.LocalDate;


public class ManagerRequestDTO {
    private String citizenId;
    private String name;
    private LocalDate dateOfBirth;//Retirement benefits?
    private String jobTitle;
    private LocalDate dateOfEmployment;
    private LocalDate dateOfLeave;
    private double baseSalary;
    private double ratePerHour;
    private boolean active;
    private Long departmentId;

    public String getCitizenId() {
        return citizenId;
    }

    public ManagerRequestDTO setCitizenId(String citizenId) {
        this.citizenId = citizenId;
        return this;
    }

    public String getName() {
        return name;
    }

    public ManagerRequestDTO setName(String name) {
        this.name = name;
        return this;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public ManagerRequestDTO setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
        return this;
    }


    public String getJobTitle() {
        return jobTitle;
    }

    public ManagerRequestDTO setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
        return this;
    }

    public LocalDate getDateOfEmployment() {
        return dateOfEmployment;
    }

    public ManagerRequestDTO setDateOfEmployment(LocalDate dateOfEmployment) {
        this.dateOfEmployment = dateOfEmployment;
        return this;
    }

    public LocalDate getDateOfLeave() {
        return dateOfLeave;
    }

    public ManagerRequestDTO setDateOfLeave(LocalDate dateOfLeave) {
        this.dateOfLeave = dateOfLeave;
        return this;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public ManagerRequestDTO setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
        return this;
    }

    public double getRatePerHour() {
        return ratePerHour;
    }

    public ManagerRequestDTO setRatePerHour(double ratePerHour) {
        this.ratePerHour = ratePerHour;
        return this;
    }

    public boolean isActive() {
        return active;
    }

    public ManagerRequestDTO setActive(boolean active) {
        this.active = active;
        return this;
    }

    public Long getDepartmentId() {
        return departmentId;
    }

    public ManagerRequestDTO setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
        return this;
    }
}
