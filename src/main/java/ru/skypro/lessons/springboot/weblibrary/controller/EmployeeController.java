package ru.skypro.lessons.springboot.weblibrary.controller;

import org.springframework.web.bind.annotation.*;
import ru.skypro.lessons.springboot.weblibrary.pojo.Employee;
import ru.skypro.lessons.springboot.weblibrary.service.EmployeeService;


import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @GetMapping
    public List <Employee> showCounter () {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/salary/sum")
    public Integer findSumSalaries (){
        return employeeService.findSumSalaries();
    }
    @GetMapping("/salary/min")
    public Employee findMinSalary (){
        return employeeService.findMinSalary();
    }
    @GetMapping("/salary/max")
    public Employee findMaxSalary (){
        return employeeService.findMaxSalary();
    }

    @GetMapping("/salary/high-salary")
    public List<Employee> findHighSalary (){
        return employeeService.findHighSalary();
    }
    @PostMapping("/")
    public List <Employee> addEmployees(@RequestBody List <Employee> employeeList) {
        return employeeService.addEmployees(employeeList);

    }
    @PutMapping("/{id}")
    public void editEmployee(@PathVariable int id,
                             @RequestBody Employee employee) {
       employeeService.editEmployee(id, employee);
    }

    @GetMapping ("/{id}")
    public Employee getEmployee(@PathVariable int id) {
       return employeeService.getEmployee(id);
    }
    @DeleteMapping ("/{id}")
    public void deleteEmployee (@PathVariable int id) {
        employeeService.deleteEmployee(id);
    }
    @GetMapping ("/salaryHigherThan")
    public List<Employee> getEmployeeWithSalaryHigherThan (@RequestParam int salary) {
        return employeeService.getEmployeeWithSalaryHigherThan(salary);
    }
}
