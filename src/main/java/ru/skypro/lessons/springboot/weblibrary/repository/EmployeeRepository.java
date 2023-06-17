package ru.skypro.lessons.springboot.weblibrary.repository;

import ru.skypro.lessons.springboot.weblibrary.pojo.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository {
    List<Employee> getAllEmployees();
    Employee addEmployee(Employee employee);
    public void editEmployee (int id, Employee employee);
    public void deleteEmployee (int id);
    public Optional<Employee> findById(int id);

}
