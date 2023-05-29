package ru.skypro.lessons.springboot.weblibrary.repository;

import org.springframework.stereotype.Repository;
import ru.skypro.lessons.springboot.weblibrary.pojo.Employee;

import java.util.List;
@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository{
    private final List <Employee> employeeList = List.of(
            new Employee("Harry", 100_000),
            new Employee("Hermione", 200_000),
            new Employee("Ron", 80_000),
            new Employee("Draco", 140_000),
            new Employee("Neville", 110_000)
    );

    @Override
    public List<Employee> getAllEmployees() {
        return employeeList ;
    }

}
