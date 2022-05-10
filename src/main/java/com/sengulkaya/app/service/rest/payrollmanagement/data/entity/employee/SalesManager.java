package com.sengulkaya.app.service.rest.payrollmanagement.data.entity.employee;

import javax.persistence.Entity;
import java.time.LocalDate;

@Entity
public class SalesManager extends Manager {
    private double bonus;

    @Override
    public long getEmployeeId() {
        return super.getEmployeeId();
    }

    @Override
    public void setEmployeeId(long employeeId) {
        super.setEmployeeId(employeeId);
    }

    @Override
    public String getCitizenId() {
        return super.getCitizenId();
    }

    @Override
    public void setCitizenId(String citizenId) {
        super.setCitizenId(citizenId);
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }

    @Override
    public LocalDate getDateOfBirth() {
        return super.getDateOfBirth();
    }

    @Override
    public void setDateOfBirth(LocalDate dateOfBirth) {
        super.setDateOfBirth(dateOfBirth);
    }

    @Override
    public Department getDepartment() {
        return super.getDepartment();
    }

    @Override
    public void setDepartment(Department department) {
        super.setDepartment(department);
    }

    @Override
    public long getDepartmentId() {
        return super.getDepartmentId();
    }

    @Override
    public void setDepartmentId(long departmentId) {
        super.setDepartmentId(departmentId);
    }

    @Override
    public String getJobTitle() {
        return super.getJobTitle();
    }

    @Override
    public void setJobTitle(String jobTitle) {
        super.setJobTitle(jobTitle);
    }

    @Override
    public LocalDate getDateOfEmployment() {
        return super.getDateOfEmployment();
    }

    @Override
    public void setDateOfEmployment(LocalDate dateOfEmployment) {
        super.setDateOfEmployment(dateOfEmployment);
    }

    @Override
    public LocalDate getDateOfLeave() {
        return super.getDateOfLeave();
    }

    @Override
    public void setDateOfLeave(LocalDate dateOfLeave) {
        super.setDateOfLeave(dateOfLeave);
    }

    @Override
    public double getBaseSalary() {
        return super.getBaseSalary();
    }

    @Override
    public void setBaseSalary(double baseSalary) {
        super.setBaseSalary(baseSalary);
    }

    @Override
    public int getOvertime() {
        return super.getOvertime();
    }

    @Override
    public void setOvertime(int overtime) {
        super.setOvertime(overtime);
    }

    @Override
    public double getRatePerHour() {
        return super.getRatePerHour();
    }

    @Override
    public void setRatePerHour(double ratePerHour) {
        super.setRatePerHour(ratePerHour);
    }

    @Override
    public boolean isActive() {
        return super.isActive();
    }

    @Override
    public void setActive(boolean active) {
        super.setActive(active);
    }

    @Override
    public double calculateInsurancePayment(double pay) {
        return super.calculateInsurancePayment(pay);
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }
}
