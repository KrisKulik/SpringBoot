package ru.skypro.lessons.springboot.weblibrary.service;

import org.springframework.stereotype.Service;
import ru.skypro.lessons.springboot.weblibrary.dto.EmployeeDTO;
import ru.skypro.lessons.springboot.weblibrary.dto.EmployeeFullInfo;
import ru.skypro.lessons.springboot.weblibrary.repository.EmployeeRepository;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<EmployeeFullInfo> getAllEmployees() {
        return employeeRepository.findAllEmployeeFullInfo();
    }

    @Override
    public Integer findSumSalaries() {
        return getAllEmployees().stream().flatMapToInt(employee -> IntStream.of(employee.getSalary())).sum();
    }

    @Override
    public Optional<EmployeeFullInfo> findMinSalary() {
        return getAllEmployees().stream().min(Comparator.comparingDouble(EmployeeFullInfo::getSalary));
    }

    @Override
    public Optional<EmployeeFullInfo> findMaxSalary() {
        return getAllEmployees().stream().max(Comparator.comparingDouble(EmployeeFullInfo::getSalary));
    }

    @Override
    public List<EmployeeFullInfo> findHighSalary() {
        int employeeRepositorySize = getAllEmployees().size();
        int averageSalary = findSumSalaries()/employeeRepositorySize;
        return getAllEmployees().stream().filter(e -> e.getSalary()>averageSalary).collect(Collectors.toList());
    }

    @Override
    public void addEmployees(EmployeeDTO employeeDTO) {
            employeeRepository.save(employeeDTO.toEmployee());
        }

    @Override
    public void editEmployee(EmployeeDTO employeeDTO) {
            employeeRepository.save(employeeDTO.toEmployee());
        }

    @Override
    public EmployeeDTO getEmployeeById(Integer id) {
        return EmployeeDTO.fromEmployee(employeeRepository.findById(id).orElseThrow(IllegalArgumentException::new));

    }

    @Override
    public void deleteEmployeeById(Integer id) {
            employeeRepository.deleteById(id);
        }
    @Override
    public List<EmployeeFullInfo> getEmployeeWithSalaryHigherThan(double salary) {
        return getAllEmployees().stream().filter(employee -> employee.getSalary() > salary).collect(Collectors.toList());
        }

    public List<EmployeeFullInfo> getEmployeeByPosition(Integer position) {
        return employeeRepository.findEmployeeByPosition(position);
        }
    @Override
    public EmployeeFullInfo getEmployeeByIdFullInfo(Integer id) {
        return employeeRepository.findByIdFullInfo(id).orElseThrow(IllegalArgumentException::new);
    }

}
