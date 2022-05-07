package com.sengulkaya.app.service.rest.payrollmanagement.data.entity.employee;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
public class Manager extends Employee{
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
    public long getDepartmantId() {
        return super.getDepartmantId();
    }

    @Override
    public void setDepartmantId(long departmantId) {
        super.setDepartmantId(departmantId);
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
}
