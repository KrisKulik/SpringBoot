package ru.skypro.lessons.springboot.weblibrary.service;

import ru.skypro.lessons.springboot.weblibrary.dto.EmployeeDTO;
import ru.skypro.lessons.springboot.weblibrary.dto.EmployeeFullInfo;
import ru.skypro.lessons.springboot.weblibrary.dto.EmployeeReport;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    List <EmployeeFullInfo> getAllEmployees();
    Integer findSumSalaries();
    Optional <EmployeeFullInfo> findMinSalary();
    Optional<EmployeeFullInfo> findMaxSalary();
    List <EmployeeFullInfo> findAboveAverageSalary();
    void addEmployees(EmployeeDTO employeeDTO);
    void editEmployee(EmployeeDTO employeeDTO);
    EmployeeDTO getEmployeeById(Integer id);
    void deleteEmployeeById(Integer id);
    List <EmployeeFullInfo> getEmployeeWithSalaryHigherThan(Integer salary);
    List<EmployeeFullInfo> getEmployeeByPosition(Integer position);
    EmployeeFullInfo getEmployeeByIdFullInfo(Integer id);
    List<EmployeeDTO> getEmployeeByPage(Integer page);
    List<EmployeeDTO> findTheHighestSalary();
    List<EmployeeReport> getReport();
}
