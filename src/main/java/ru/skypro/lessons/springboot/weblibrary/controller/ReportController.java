package ru.skypro.lessons.springboot.weblibrary.controller;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.skypro.lessons.springboot.weblibrary.dto.ReportDTO;
import ru.skypro.lessons.springboot.weblibrary.service.EmployeeService;
import ru.skypro.lessons.springboot.weblibrary.service.ReportService;

@RestController
@RequestMapping("/report")
public class ReportController {
    private final EmployeeService employeeService;
    private final ReportService reportService;

    public ReportController(EmployeeService employeeService, ReportService reportService) {
        this.employeeService = employeeService;
        this.reportService = reportService;
    }

    public EmployeeService getEmployeeService() {
        return employeeService;
    }

    public ReportService getReportService() {
        return reportService;
    }

    @PostMapping("/")
    public Integer getReport() {
        return reportService.addReport();
    }
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public ResponseEntity<Resource> getReportById(@PathVariable Integer id) {
        return reportService.getReportById(id);
    }

}
