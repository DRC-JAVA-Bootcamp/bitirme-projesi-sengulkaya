package com.sengulkaya.app.service.rest.payrollmanagement.dto.requestDTO;

import org.springframework.stereotype.Component;

import java.time.LocalDate;


public class ProjectWorkerRequestDTO extends WorkerRequestDTO {
    private String projectName;

    @Override
    public String getCitizenId() {
        return super.getCitizenId();
    }

    @Override
    public WorkerRequestDTO setCitizenId(String citizenId) {
        return super.setCitizenId(citizenId);
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public WorkerRequestDTO setName(String name) {
        return super.setName(name);
    }

    @Override
    public LocalDate getDateOfBirth() {
        return super.getDateOfBirth();
    }

    @Override
    public WorkerRequestDTO setDateOfBirth(LocalDate dateOfBirth) {
        return super.setDateOfBirth(dateOfBirth);
    }

    @Override
    public String getDepartment() {
        return super.getDepartment();
    }

    @Override
    public WorkerRequestDTO setDepartment(String department) {
        return super.setDepartment(department);
    }

    @Override
    public String getJobTitle() {
        return super.getJobTitle();
    }

    @Override
    public WorkerRequestDTO setJobTitle(String jobTitle) {
        return super.setJobTitle(jobTitle);
    }

    @Override
    public LocalDate getDateOfEmployment() {
        return super.getDateOfEmployment();
    }

    @Override
    public WorkerRequestDTO setDateOfEmployment(LocalDate dateOfEmployment) {
        return super.setDateOfEmployment(dateOfEmployment);
    }

    @Override
    public double getBaseSalary() {
        return super.getBaseSalary();
    }

    @Override
    public WorkerRequestDTO setBaseSalary(double baseSalary) {
        return super.setBaseSalary(baseSalary);
    }

    @Override
    public double getRatePerHour() {
        return super.getRatePerHour();
    }

    @Override
    public WorkerRequestDTO setRatePerHour(double ratePerHour) {
        return super.setRatePerHour(ratePerHour);
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }
}
