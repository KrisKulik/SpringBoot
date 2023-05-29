package ru.skypro.lessons.springboot.weblibrary.service;

import org.springframework.stereotype.Service;
import ru.skypro.lessons.springboot.weblibrary.pojo.Employee;
import ru.skypro.lessons.springboot.weblibrary.repository.EmployeeRepository;

import java.util.Comparator;
import java.util.List;
@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.getAllEmployees();
    }

    @Override
    public Integer findSumSalaries() {
        int sum = 0;
        List<Integer> sumSalariesList = employeeRepository.getAllEmployees().stream().map(employee -> employee.getSalary()).toList();
        for (Integer salary : sumSalariesList) {
            sum = sum + salary;
        }
        return sum;
    }

    @Override
    public Employee findMinSalary() {
        return employeeRepository.getAllEmployees().stream().min(Comparator.comparing(employee -> employee.getSalary())).orElse(null);
    }

    @Override
    public Employee findMaxSalary() {
        return employeeRepository.getAllEmployees().stream().max(Comparator.comparing(employee -> employee.getSalary())).orElse(null);
    }

    @Override
    public List<Employee> findHighSalary() {
        int employeeRepositorySize = employeeRepository.getAllEmployees().size();
        int averageSalary = findSumSalaries()/employeeRepositorySize;
        return employeeRepository.getAllEmployees().stream().filter(employee -> employee.getSalary() > averageSalary).toList();
    }
}
