package ru.skypro.lessons.springboot.weblibrary.service;

import org.springframework.stereotype.Service;
import ru.skypro.lessons.springboot.weblibrary.exceptions.EmployeeNotFoundException;
import ru.skypro.lessons.springboot.weblibrary.exceptions.EmployeeNotValidException;
import ru.skypro.lessons.springboot.weblibrary.pojo.Employee;
import ru.skypro.lessons.springboot.weblibrary.repository.EmployeeRepository;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
    @Override
    public List<Employee> addEmployees(List<Employee> employeeList) {
        Optional<Employee> incorrectEmployee = employeeList.stream()
                .filter(employee -> employee.getSalary() <= 0 || employee.getName() == null || employee.getName().isEmpty())
                .findFirst();

        if(incorrectEmployee.isPresent()){
            throw new EmployeeNotValidException(incorrectEmployee.get());
        }
        return employeeList.stream()
                .map(employee -> new Employee(employee.getName(), employee.getSalary()))
                .map(employeeRepository::addEmployee)
                .collect(Collectors.toList());
    }

    @Override
    public void editEmployee(int id, Employee employee) {
        Employee oldEmployee = employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException(id));
        oldEmployee.setSalary(employee.getSalary());
        oldEmployee.setName(employee.getName());
        employeeRepository.editEmployee(id, oldEmployee);
    }

    @Override
    public Employee getEmployee(int id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException(id));
    }

    @Override
    public void deleteEmployee(int id) {
        employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException(id));
        employeeRepository.deleteEmployee(id);
    }

    @Override
    public List<Employee> getEmployeeWithSalaryHigherThan(double salary) {
        return employeeRepository.getAllEmployees().stream()
                .filter(employee -> employee.getSalary() > salary)
                .collect(Collectors.toList());
    }
}
