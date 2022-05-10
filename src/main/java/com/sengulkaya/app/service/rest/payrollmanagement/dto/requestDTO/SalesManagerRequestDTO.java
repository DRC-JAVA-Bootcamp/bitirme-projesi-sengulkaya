package com.sengulkaya.app.service.rest.payrollmanagement.dto.requestDTO;

import org.springframework.stereotype.Component;

import java.time.LocalDate;


public class SalesManagerRequestDTO extends ManagerRequestDTO {

    @Override
    public String getCitizenId() {
        return super.getCitizenId();
    }

    @Override
    public SalesManagerRequestDTO setCitizenId(String citizenId) {
        super.setCitizenId(citizenId);
        return this;
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public SalesManagerRequestDTO setName(String name) {
        super.setName(name);
        return this;
    }

    @Override
    public LocalDate getDateOfBirth() {
        return super.getDateOfBirth();
    }

    @Override
    public SalesManagerRequestDTO setDateOfBirth(LocalDate dateOfBirth) {
        super.setDateOfBirth(dateOfBirth);
        return this;
    }


    @Override
    public String getJobTitle() {
        return super.getJobTitle();
    }

    @Override
    public SalesManagerRequestDTO setJobTitle(String jobTitle) {
        super.setJobTitle(jobTitle);
        return this;
    }

    @Override
    public LocalDate getDateOfEmployment() {
        return super.getDateOfEmployment();
    }

    @Override
    public SalesManagerRequestDTO setDateOfEmployment(LocalDate dateOfEmployment) {
        super.setDateOfEmployment(dateOfEmployment);
        return this;
    }

    @Override
    public LocalDate getDateOfLeave() {
        return super.getDateOfLeave();
    }

    @Override
    public SalesManagerRequestDTO setDateOfLeave(LocalDate dateOfLeave) {
        super.setDateOfLeave(dateOfLeave);
        return this;
    }

    @Override
    public double getBaseSalary() {
        return super.getBaseSalary();
    }

    @Override
    public SalesManagerRequestDTO setBaseSalary(double baseSalary) {
        super.setBaseSalary(baseSalary);
        return this;
    }

    @Override
    public double getRatePerHour() {
        return super.getRatePerHour();
    }

    @Override
    public SalesManagerRequestDTO setRatePerHour(double ratePerHour) {
        super.setRatePerHour(ratePerHour);
        return this;
    }

    @Override
    public boolean isActive() {
        return super.isActive();
    }

    @Override
    public SalesManagerRequestDTO setActive(boolean active) {
        super.setActive(active);
        return this;
    }

    @Override
    public Long getDepartmentId() {
        return super.getDepartmentId();
    }

    @Override
    public SalesManagerRequestDTO setDepartmentId(Long departmentId) {
        super.setDepartmentId(departmentId);
        return this;
    }

}
