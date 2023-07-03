package ru.skypro.lessons.springboot.weblibrary.exceptions;

import ru.skypro.lessons.springboot.weblibrary.pojo.Employee;

public class EmployeeNotValidException extends RuntimeException {
    Employee employee;

    public EmployeeNotValidException(Employee employee) {
        this.employee = employee;
    }

    public Employee getEmployee() {
        return employee;
    }
}
