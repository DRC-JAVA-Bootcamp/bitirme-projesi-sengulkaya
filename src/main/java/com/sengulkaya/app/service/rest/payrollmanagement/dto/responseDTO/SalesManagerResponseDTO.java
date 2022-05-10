package com.sengulkaya.app.service.rest.payrollmanagement.dto.responseDTO;

import java.time.LocalDate;

public class SalesManagerResponseDTO {
    private String citizenId;
    private String name;
    private LocalDate dateOfBirth;//Retirement benefits?
    private String departmentName;
    private String jobTitle;
    private LocalDate dateOfEmployment;
    private double baseSalary;
    private double ratePerHour;
    private boolean active;
    private double sales;
    private double bonus;
    private Long departmentId;
    private Long employeeId;

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


    public String getJobTitle() {
        return jobTitle;
    }

    public SalesManagerResponseDTO setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
        return this;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public SalesManagerResponseDTO setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
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

    public boolean isActive() {
        return active;
    }

    public SalesManagerResponseDTO setActive(boolean active) {
        this.active = active;
        return this;
    }

    public double getSales() {
        return sales;
    }

    public SalesManagerResponseDTO setSales(double sales) {
        this.sales = sales;
        return this;
    }

    public double getBonus() {
        return bonus;
    }

    public SalesManagerResponseDTO setBonus(double bonus) {
        this.bonus = bonus;
        return this;
    }

    public Long getDepartmentId() {
        return departmentId;
    }

    public SalesManagerResponseDTO setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
        return this;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public SalesManagerResponseDTO setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
        return this;
    }
}
