package com.sengulkaya.app.service.rest.payrollmanagement.dto.responseDTO;

import java.time.LocalDate;

public class SalesManagerResponseDTO {
    private String citizenId;
    private String name;
    private LocalDate dateOfBirth;//Retirement benefits?
    private String department;
    private String jobTitle;
    private LocalDate dateOfEmployment;
    private double baseSalary;
    private double ratePerHour;
    private double bonus;

    public String getCitizenId() {
        return citizenId;
    }

    public SalesManagerResponseDTO setCitizenId(String citizenId) {
        this.citizenId = citizenId;
        return this;
    }

    public String getName() {
        return name;
    }

    public SalesManagerResponseDTO setName(String name) {
        this.name = name;
        return this;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public SalesManagerResponseDTO setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
        return this;
    }

    public String getDepartment() {
        return department;
    }

    public SalesManagerResponseDTO setDepartment(String department) {
        this.department = department;
        return this;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public SalesManagerResponseDTO setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
        return this;
    }

    public LocalDate getDateOfEmployment() {
        return dateOfEmployment;
    }

    public SalesManagerResponseDTO setDateOfEmployment(LocalDate dateOfEmployment) {
        this.dateOfEmployment = dateOfEmployment;
        return this;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public SalesManagerResponseDTO setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
        return this;
    }

    public double getRatePerHour() {
        return ratePerHour;
    }

    public SalesManagerResponseDTO setRatePerHour(double ratePerHour) {
        this.ratePerHour = ratePerHour;
        return this;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }
}
