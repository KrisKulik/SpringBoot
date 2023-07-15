package ru.skypro.lessons.springboot.weblibrary.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.PathResource;
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
    public Integer getReport() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(employeeService.getReport());
        File file = new File("report.json");
        Files.writeString(file.toPath(), json);
        ReportPathDTO reportPathDTO = new ReportPathDTO();
        reportPathDTO.setPath(file.getAbsolutePath());
        return reportPathService.addReportPath(reportPathDTO);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public ResponseEntity<PathResource> getReportById(@PathVariable Integer id) {
        String fileName = "report.json";
        String path = reportPathService.getReportPathById(id).getPath();
        File file = new File(path);
        PathResource pathResource = new PathResource(file.getPath());
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileName + "\"")
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .body(pathResource);
    }
}
