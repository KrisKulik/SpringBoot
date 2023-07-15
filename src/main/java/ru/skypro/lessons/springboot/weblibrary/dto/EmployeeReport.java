package ru.skypro.lessons.springboot.weblibrary.dto;

import java.io.Serializable;

public class EmployeeReport implements Serializable {
        private Integer department;
        private Long countEmployees;
        private Integer minSalary;
        private Integer maxSalary;
        private Double averageSalary;

    public EmployeeReport(Integer department,
                          Long countEmployees,
                          Integer minSalary,
                          Integer maxSalary,
                          Double averageSalary) {

        this.department = department;
        this.countEmployees = countEmployees;
        this.minSalary = minSalary;
        this.maxSalary = maxSalary;
        this.averageSalary = averageSalary;
    }

    public Integer getDepartment() {
        return department;
    }

    public void setDepartment(Integer department) {
        this.department = department;
    }

    public Long getCountEmployees() {
        return countEmployees;
    }

    public void setCountEmployees(Long countEmployees) {
        this.countEmployees = countEmployees;
    }

    public Integer getMinSalary() {
        return minSalary;
    }

    public void setMinSalary(Integer minSalary) {
        this.minSalary = minSalary;
    }

    public Integer getMaxSalary() {
        return maxSalary;
    }

    public void setMaxSalary(Integer maxSalary) {
        this.maxSalary = maxSalary;
    }

    public Double getAverageSalary() {
        return averageSalary;
    }

    public void setAverageSalary(Double averageSalary) {
        this.averageSalary = averageSalary;
    }
}

