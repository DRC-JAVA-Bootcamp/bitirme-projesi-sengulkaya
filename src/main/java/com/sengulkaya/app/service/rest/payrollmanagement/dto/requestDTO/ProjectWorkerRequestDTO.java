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
    public ProjectWorkerRequestDTO setCitizenId(String citizenId) {
        super.setCitizenId(citizenId);
        return this;
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public ProjectWorkerRequestDTO setName(String name) {
        super.setName(name);
        return this;
    }

    @Override
    public LocalDate getDateOfBirth() {
        return super.getDateOfBirth();
    }

    @Override
    public ProjectWorkerRequestDTO setDateOfBirth(LocalDate dateOfBirth) {
        super.setDateOfBirth(dateOfBirth);
        return this;
    }


    @Override
    public String getJobTitle() {
        return super.getJobTitle();
    }

    @Override
    public ProjectWorkerRequestDTO setJobTitle(String jobTitle) {
        super.setJobTitle(jobTitle);
        return this;
    }

    @Override
    public LocalDate getDateOfEmployment() {
        return super.getDateOfEmployment();
    }

    @Override
    public ProjectWorkerRequestDTO setDateOfEmployment(LocalDate dateOfEmployment) {
        super.setDateOfEmployment(dateOfEmployment);
        return this;
    }

    @Override
    public LocalDate getDateOfLeave() {
        return super.getDateOfLeave();
    }

    @Override
    public ProjectWorkerRequestDTO setDateOfLeave(LocalDate dateOfLeave) {
        super.setDateOfLeave(dateOfLeave);
        return this;
    }

    @Override
    public double getBaseSalary() {
        return super.getBaseSalary();
    }

    @Override
    public ProjectWorkerRequestDTO setBaseSalary(double baseSalary) {
        super.setBaseSalary(baseSalary);
        return this;
    }

    @Override
    public double getRatePerHour() {
        return super.getRatePerHour();
    }

    @Override
    public ProjectWorkerRequestDTO setRatePerHour(double ratePerHour) {
        super.setRatePerHour(ratePerHour);
        return this;
    }

    @Override
    public boolean isActive() {
        return super.isActive();
    }

    @Override
    public ProjectWorkerRequestDTO setActive(boolean active) {
        super.setActive(active);
        return this;
    }

    @Override
    public Long getDepartmentId() {
        return super.getDepartmentId();
    }

    @Override
    public ProjectWorkerRequestDTO setDepartmentId(Long departmentId) {
        super.setDepartmentId(departmentId);
        return this;
    }

    public String getProjectName() {
        return projectName;
    }

    public ProjectWorkerRequestDTO setProjectName(String projectName) {
        this.projectName = projectName;
        return this;
    }
}
