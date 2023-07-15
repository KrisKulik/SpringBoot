package ru.skypro.lessons.springboot.weblibrary.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.skypro.lessons.springboot.weblibrary.dto.EmployeeDTO;
import ru.skypro.lessons.springboot.weblibrary.dto.EmployeeFullInfo;
import ru.skypro.lessons.springboot.weblibrary.dto.EmployeeReport;
import ru.skypro.lessons.springboot.weblibrary.service.EmployeeService;


import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
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
    @PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public void uploadEmployeeFromFile(@RequestParam("file") MultipartFile file) {
        try (InputStream inputStream = file.getInputStream()) {
            int streamSize = inputStream.available();
            byte[] bytes = new byte[streamSize];
            inputStream.read(bytes);
            String json = new String(bytes, StandardCharsets.UTF_8);
            ObjectMapper objectMapper = new ObjectMapper();
            EmployeeDTO employeeDTO = objectMapper.readValue(json, EmployeeDTO.class);
            employeeService.addEmployees(employeeDTO);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @GetMapping("/employeeReport")
    public List<EmployeeReport> getEmployeeReport() {
        return employeeService.getReport();
    }
}
