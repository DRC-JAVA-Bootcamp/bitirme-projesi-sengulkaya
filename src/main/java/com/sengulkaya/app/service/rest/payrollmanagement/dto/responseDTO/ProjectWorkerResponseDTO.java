package com.sengulkaya.app.service.rest.payrollmanagement.dto.responseDTO;

import java.time.LocalDate;

public class ProjectWorkerResponseDTO {
    private String citizenId;
    private String name;
    private LocalDate dateOfBirth;//Retirement benefits?
    private String departmentName;
    private String jobTitle;
    private LocalDate dateOfEmployment;
    private double baseSalary;
    private double ratePerHour;
    private String projectName;
    private boolean active;
    private Long departmentId;
    private Long employeeId;

    public String getCitizenId() {
        return citizenId;
    }

    public ProjectWorkerResponseDTO setCitizenId(String citizenId) {
        this.citizenId = citizenId;
        return this;
    }

    public String getName() {
        return name;
    }

    public ProjectWorkerResponseDTO setName(String name) {
        this.name = name;
        return this;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public ProjectWorkerResponseDTO setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
        return this;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public ProjectWorkerResponseDTO setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
        return this;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public ProjectWorkerResponseDTO setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
        return this;
    }

    public LocalDate getDateOfEmployment() {
        return dateOfEmployment;
    }

    public ProjectWorkerResponseDTO setDateOfEmployment(LocalDate dateOfEmployment) {
        this.dateOfEmployment = dateOfEmployment;
        return this;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public ProjectWorkerResponseDTO setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
        return this;
    }

    public double getRatePerHour() {
        return ratePerHour;
    }

    public ProjectWorkerResponseDTO setRatePerHour(double ratePerHour) {
        this.ratePerHour = ratePerHour;
        return this;
    }

    public String getProjectName() {
        return projectName;
    }

    public ProjectWorkerResponseDTO setProjectName(String projectName) {
        this.projectName = projectName;
        return this;
    }

    public boolean isActive() {
        return active;
    }

    public ProjectWorkerResponseDTO setActive(boolean active) {
        this.active = active;
        return this;
    }

    public Long getDepartmentId() {
        return departmentId;
    }

    public ProjectWorkerResponseDTO setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
        return this;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public ProjectWorkerResponseDTO setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
        return this;
    }
}
