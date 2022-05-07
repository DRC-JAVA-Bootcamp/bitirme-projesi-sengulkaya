package com.sengulkaya.app.service.rest.payrollmanagement.dto.requestDTO;

import org.springframework.stereotype.Component;

import java.time.LocalDate;


public class SalesManagerRequestDTO extends ManagerRequestDTO {
    private double bonus;

    @Override
    public String getCitizenId() {
        return super.getCitizenId();
    }

    @Override
    public ManagerRequestDTO setCitizenId(String citizenId) {
        return super.setCitizenId(citizenId);
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public ManagerRequestDTO setName(String name) {
        return super.setName(name);
    }

    @Override
    public LocalDate getDateOfBirth() {
        return super.getDateOfBirth();
    }

    @Override
    public ManagerRequestDTO setDateOfBirth(LocalDate dateOfBirth) {
        return super.setDateOfBirth(dateOfBirth);
    }

    @Override
    public String getDepartment() {
        return super.getDepartment();
    }

    @Override
    public ManagerRequestDTO setDepartment(String department) {
        return super.setDepartment(department);
    }

    @Override
    public String getJobTitle() {
        return super.getJobTitle();
    }

    @Override
    public ManagerRequestDTO setJobTitle(String jobTitle) {
        return super.setJobTitle(jobTitle);
    }

    @Override
    public LocalDate getDateOfEmployment() {
        return super.getDateOfEmployment();
    }

    @Override
    public ManagerRequestDTO setDateOfEmployment(LocalDate dateOfEmployment) {
        return super.setDateOfEmployment(dateOfEmployment);
    }

    @Override
    public double getBaseSalary() {
        return super.getBaseSalary();
    }

    @Override
    public ManagerRequestDTO setBaseSalary(double baseSalary) {
        return super.setBaseSalary(baseSalary);
    }

    @Override
    public double getRatePerHour() {
        return super.getRatePerHour();
    }

    @Override
    public ManagerRequestDTO setRatePerHour(double ratePerHour) {
        return super.setRatePerHour(ratePerHour);
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }
}
