package com.sengulkaya.app.service.rest.payrollmanagement.data.entity.employee;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.sengulkaya.app.service.rest.payrollmanagement.data.entity.employee.contracts.ILifeInsurance;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@Entity
@Table(name = "Employees")
public abstract class Employee implements ILifeInsurance {
    @Id
    @Column(name = "employee_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long employeeId;

    @Column(name = "citizen_id", nullable = false, unique = true)
    private String citizenId;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "date_of_birth", nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate dateOfBirth;//Retirement benefits?

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id")
    private Department department;

    @Transient
    private long departmentId;

    @Column(name = "job_title", nullable = false)
    private String jobTitle;

    @Column(name = "date_of_employment", nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate dateOfEmployment;

    @Column(name = "date_of_leave")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate dateOfLeave;

    @Column(name = "base_salary", nullable = false)
    private double baseSalary;

    @Column(name = "overtime", nullable = false)
    private int overtime;

    @Column(name = "rate_per_hour", nullable = false)
    private double ratePerHour;

    @Column(name = "active", nullable = false)
    private boolean active;



    public long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
    }

    public String getCitizenId() {
        return citizenId;
    }

    public void setCitizenId(String citizenId) {
        this.citizenId = citizenId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(long departmentId) {
        this.departmentId = departmentId;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public LocalDate getDateOfEmployment() {
        return dateOfEmployment;
    }

    public void setDateOfEmployment(LocalDate dateOfEmployment) {
        this.dateOfEmployment = dateOfEmployment;
    }

    public LocalDate getDateOfLeave() {
        return dateOfLeave;
    }

    public void setDateOfLeave(LocalDate dateOfLeave) {
        this.dateOfLeave = dateOfLeave;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public int getOvertime() {
        return overtime;
    }

    public void setOvertime(int overtime) {
        this.overtime = overtime;
    }

    public double getRatePerHour() {
        return ratePerHour;
    }

    public void setRatePerHour(double ratePerHour) {
        this.ratePerHour = ratePerHour;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public double calculateTotalPayment() {
        return getBaseSalary() + getOvertime() * getRatePerHour();
    }

    @Override
    public double calculateInsurancePayment() {
        double total = calculateTotalPayment();
        double insurancePayment = total * setBraket(total).getPercentile();
        System.out.println(getEmployeeId() + ". " + getName() + ": " + insurancePayment + " life insurance payment");
        return insurancePayment;
    }
}
