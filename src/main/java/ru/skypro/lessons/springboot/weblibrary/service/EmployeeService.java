package ru.skypro.lessons.springboot.weblibrary.service;

import ru.skypro.lessons.springboot.weblibrary.pojo.Employee;

import java.util.List;

public interface EmployeeService {
    List <Employee> getAllEmployees();
    Integer findSumSalaries();
    Employee findMinSalary();
    Employee findMaxSalary();
    List <Employee> findHighSalary();
    List<Employee> addEmployees(List <Employee> employeeList);
    void editEmployee(int id, Employee employee);
    Employee getEmployee(int id);
    void deleteEmployee(int id);
    List<Employee> getEmployeeWithSalaryHigherThan(double salary);
}
