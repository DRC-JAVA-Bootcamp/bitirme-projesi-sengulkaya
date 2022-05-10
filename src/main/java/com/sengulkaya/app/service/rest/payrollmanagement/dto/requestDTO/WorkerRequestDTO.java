package com.sengulkaya.app.service.rest.payrollmanagement.dto.requestDTO;

import org.springframework.stereotype.Component;

import java.time.LocalDate;


public class WorkerRequestDTO {
    private String citizenId;
    private String name;
    private LocalDate dateOfBirth;//Retirement benefits?
    private String jobTitle;
    private LocalDate dateOfEmployment;
    private double baseSalary;
    private double ratePerHour;
    private boolean active;
    private Long departmentId;


    public String getCitizenId() {
        return citizenId;
    }

    public WorkerRequestDTO setCitizenId(String citizenId) {
        this.citizenId = citizenId;
        return this;
    }

    public String getName() {
        return name;
    }

    public WorkerRequestDTO setName(String name) {
        this.name = name;
        return this;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public WorkerRequestDTO setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
        return this;
    }


    public String getJobTitle() {
        return jobTitle;
    }

    public WorkerRequestDTO setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
        return this;
    }

    public LocalDate getDateOfEmployment() {
        return dateOfEmployment;
    }

    public WorkerRequestDTO setDateOfEmployment(LocalDate dateOfEmployment) {
        this.dateOfEmployment = dateOfEmployment;
        return this;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public WorkerRequestDTO setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
        return this;
    }

    public double getRatePerHour() {
        return ratePerHour;
    }

    public WorkerRequestDTO setRatePerHour(double ratePerHour) {
        this.ratePerHour = ratePerHour;
        return this;
    }

    public boolean isActive() {
        return active;
    }

    public WorkerRequestDTO setActive(boolean active) {
        this.active = active;
        return this;
    }

    public Long getDepartmentId() {
        return departmentId;
    }

    public WorkerRequestDTO setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
        return this;
    }

}
