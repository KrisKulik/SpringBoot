package ru.skypro.lessons.springboot.weblibrary.controller;

import org.springframework.web.bind.annotation.*;
import ru.skypro.lessons.springboot.weblibrary.dto.EmployeeDTO;
import ru.skypro.lessons.springboot.weblibrary.dto.EmployeeFullInfo;
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
    public List<EmployeeFullInfo> findAboveAverageSalary (){
        return employeeService.findAboveAverageSalary();
    }
    @PostMapping("/")
    public void addEmployees(@RequestBody EmployeeDTO employeeDTO) {
            employeeService.addEmployees(employeeDTO);

    }
    @PutMapping("/")
    public void editEmployee(@RequestBody EmployeeDTO employeeDTO) {
        employeeService.editEmployee(employeeDTO);
    }

    @GetMapping("/{id}/fullInfo")
    public EmployeeFullInfo getEmployeeByIdFullInfo(@PathVariable Integer id) {
        return employeeService.getEmployeeByIdFullInfo(id);
    }
    @DeleteMapping ("/{id}")
    public void deleteEmployeeById (@PathVariable Integer id) {
        employeeService.deleteEmployeeById(id);;
    }
    @GetMapping ("/salaryHigherThan")
    public List<EmployeeFullInfo> getEmployeeWithSalaryHigherThan (@RequestParam("checkSalary") int salary) {
        return employeeService.getEmployeeWithSalaryHigherThan(salary);
    }
    @GetMapping("/")
    public List<EmployeeFullInfo> getEmployeeByPosition(@RequestParam("position") Integer position) {
        return employeeService.getEmployeeByPosition(position);
    }
    @GetMapping("/page")
    public List<EmployeeDTO> getEmployeeByPage(@RequestParam("page") Integer page) {
        int size = 1;
        return employeeService.getEmployeeByPage(page);
    }
    @GetMapping("/{id}")
    public EmployeeDTO getEmployeeById(@PathVariable Integer id) {
        return employeeService.getEmployeeById(id);
    }
    @GetMapping("/withHighestSalary")
    public List<EmployeeDTO> getTheHighestSalary() {
        return employeeService.findTheHighestSalary();
    }
}
