package ru.skypro.lessons.springboot.weblibrary.controller;


import org.springframework.web.bind.annotation.*;

import ru.skypro.lessons.springboot.weblibrary.dto.EmployeeFullInfo;
import ru.skypro.lessons.springboot.weblibrary.service.EmployeeService;
import java.util.List;

@RestController
@RequestMapping("/admin/employees")
public class AdminEmployeeController {

    private final EmployeeService employeeService;

    public AdminEmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/all")
    public List<EmployeeFullInfo> getEmployees() {
        return employeeService.getAllEmployees();
    }

}
