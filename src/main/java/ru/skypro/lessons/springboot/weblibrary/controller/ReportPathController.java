package ru.skypro.lessons.springboot.weblibrary.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.PathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.skypro.lessons.springboot.weblibrary.dto.ReportPathDTO;
import ru.skypro.lessons.springboot.weblibrary.service.EmployeeService;
import ru.skypro.lessons.springboot.weblibrary.service.ReportPathService;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

@RestController
@RequestMapping("/reportPath")
public class ReportPathController {
    private final ReportPathService reportPathService;
    private final EmployeeService employeeService;

    public ReportPathController(ReportPathService reportPathService, EmployeeService employeeService) {
        this.reportPathService = reportPathService;
        this.employeeService = employeeService;
    }

    @PostMapping("/")
    public Integer getReport(){
        return reportPathService.addReportPath();
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public ResponseEntity<Resource> getReportById(@PathVariable Integer id) {
        return reportPathService.getReportPathById(id);
    }
}
