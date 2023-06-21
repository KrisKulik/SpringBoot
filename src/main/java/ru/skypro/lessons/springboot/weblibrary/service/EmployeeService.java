package ru.skypro.lessons.springboot.weblibrary.service;

import ru.skypro.lessons.springboot.weblibrary.dto.EmployeeDTO;
import ru.skypro.lessons.springboot.weblibrary.dto.EmployeeFullInfo;
import ru.skypro.lessons.springboot.weblibrary.pojo.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    List <EmployeeFullInfo> getAllEmployees();
    Integer findSumSalaries();
    Optional <EmployeeFullInfo> findMinSalary();
    Optional<EmployeeFullInfo> findMaxSalary();
    List <EmployeeFullInfo> findHighSalary();
    void addEmployees(EmployeeDTO employeeDTO);
    void editEmployee(EmployeeDTO employeeDTO);
    EmployeeDTO getEmployeeById(Integer id);
    void deleteEmployeeById(Integer id);
    List <EmployeeFullInfo> getEmployeeWithSalaryHigherThan(double salary);
    List<EmployeeFullInfo> getEmployeeByPosition(Integer position);
    EmployeeFullInfo getEmployeeByIdFullInfo(Integer id);


}
