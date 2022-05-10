package com.sengulkaya.app.service.rest.payrollmanagement.dto.responseDTO;

import java.time.LocalDate;

public class ManagerResponseDTO {
    private String citizenId;
    private String name;
    private LocalDate dateOfBirth;//calculate age when setting retirement benefits?
    private String jobTitle;
    private LocalDate dateOfEmployment;
    private double baseSalary;
    private double ratePerHour;
    private boolean active;
    private Long departmentId;
    private Long employeeId;

    public String getCitizenId() {
        return citizenId;
    }

    public ManagerResponseDTO setCitizenId(String citizenId) {
        this.citizenId = citizenId;
        return this;
    }

    public String getName() {
        return name;
    }

    public ManagerResponseDTO setName(String name) {
        this.name = name;
        return this;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public ManagerResponseDTO setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
        return this;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public ManagerResponseDTO setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
        return this;
    }

    public LocalDate getDateOfEmployment() {
        return dateOfEmployment;
    }

    public ManagerResponseDTO setDateOfEmployment(LocalDate dateOfEmployment) {
        this.dateOfEmployment = dateOfEmployment;
        return this;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public ManagerResponseDTO setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
        return this;
    }

    public double getRatePerHour() {
        return ratePerHour;
    }

    public ManagerResponseDTO setRatePerHour(double ratePerHour) {
        this.ratePerHour = ratePerHour;
        return this;
    }

    public boolean isActive() {
        return active;
    }

    public ManagerResponseDTO setActive(boolean active) {
        this.active = active;
        return this;
    }

    public Long getDepartmentId() {
        return departmentId;
    }

    public ManagerResponseDTO setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
        return this;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public ManagerResponseDTO setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
        return this;
    }
}
