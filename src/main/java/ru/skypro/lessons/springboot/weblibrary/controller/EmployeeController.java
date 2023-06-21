package ru.skypro.lessons.springboot.weblibrary.controller;

import org.springframework.web.bind.annotation.*;
import ru.skypro.lessons.springboot.weblibrary.dto.EmployeeDTO;
import ru.skypro.lessons.springboot.weblibrary.dto.EmployeeFullInfo;
import ru.skypro.lessons.springboot.weblibrary.pojo.Employee;
import ru.skypro.lessons.springboot.weblibrary.service.EmployeeService;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @GetMapping
    public List<EmployeeFullInfo> showCounter () {
        return employeeService.getAllEmployees();
    }
    @GetMapping("/salary/sum")
    public Integer findSumSalaries (){
        return employeeService.findSumSalaries();
    }
    @GetMapping("/salary/min")
    public Optional<EmployeeFullInfo> findMinSalary (){
        return employeeService.findMinSalary();
    }
    @GetMapping("/salary/max")
    public Optional<EmployeeFullInfo> findMaxSalary (){
        return employeeService.findMaxSalary();
    }

    @GetMapping("/salary/high-salary")
    public List<EmployeeFullInfo> findHighSalary (){
        return employeeService.findHighSalary();
    }
    @PostMapping("/")
    public void addEmployees(@RequestBody EmployeeDTO employeeDTO) {
            employeeService.addEmployees(employeeDTO);

    }
    @PutMapping("/")
    public void editEmployee(@RequestBody EmployeeDTO employeeDTO) {
        employeeService.editEmployee(employeeDTO);
    }

    @GetMapping("/{id}/info")
    public EmployeeFullInfo getEmployeeByIdFullInfo(@PathVariable Integer id) {
        return employeeService.getEmployeeByIdFullInfo(id);
    }
    @DeleteMapping ("/{id}")
    public void deleteEmployee (@PathVariable Integer id) {
        employeeService.deleteEmployeeById(id);;
    }
    @GetMapping ("/salaryHigherThan")
    public List<EmployeeFullInfo> getEmployeeWithSalaryHigherThan (@RequestParam int salary) {
        return employeeService.getEmployeeWithSalaryHigherThan(salary);
    }
}
