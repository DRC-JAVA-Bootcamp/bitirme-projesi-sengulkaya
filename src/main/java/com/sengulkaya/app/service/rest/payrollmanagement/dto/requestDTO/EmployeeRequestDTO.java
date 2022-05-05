package com.sengulkaya.app.service.rest.payrollmanagement.dto.requestDTO;

import javax.persistence.Column;
import javax.persistence.Id;
import java.time.LocalDate;

public class EmployeeRequestDTO {
    private String citizenId;
    private String name;
    private LocalDate dateOfBirth;//Retirement benefits?
    private String department;
    private String jobTitle;
    private LocalDate dateOfEmployment;
    private double baseSalary;
    private double ratePerHour;

    public String getCitizenId() {
        return citizenId;
    }

    public EmployeeRequestDTO setCitizenId(String citizenId) {
        this.citizenId = citizenId;
        return this;
    }

    public String getName() {
        return name;
    }

    public EmployeeRequestDTO setName(String name) {
        this.name = name;
        return this;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public EmployeeRequestDTO setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
        return this;
    }

    public String getDepartment() {
        return department;
    }

    public EmployeeRequestDTO setDepartment(String department) {
        this.department = department;
        return this;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public EmployeeRequestDTO setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
        return this;
    }

    public LocalDate getDateOfEmployment() {
        return dateOfEmployment;
    }

    public EmployeeRequestDTO setDateOfEmployment(LocalDate dateOfEmployment) {
        this.dateOfEmployment = dateOfEmployment;
        return this;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public EmployeeRequestDTO setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
        return this;
    }

    public double getRatePerHour() {
        return ratePerHour;
    }

    public EmployeeRequestDTO setRatePerHour(double ratePerHour) {
        this.ratePerHour = ratePerHour;
        return this;
    }
}
