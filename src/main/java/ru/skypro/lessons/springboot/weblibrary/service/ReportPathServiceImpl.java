package ru.skypro.lessons.springboot.weblibrary.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.PathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.skypro.lessons.springboot.weblibrary.dto.ReportPathDTO;
import ru.skypro.lessons.springboot.weblibrary.repository.ReportPathRepository;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

@Service
public class ReportPathServiceImpl implements ReportPathService {

    private ReportPathRepository reportPathRepository;
    private final EmployeeService employeeService;

    Logger logger = LoggerFactory.getLogger(ReportPathServiceImpl.class);

    public ReportPathServiceImpl(ReportPathRepository reportPathRepository, EmployeeService employeeService) {
        this.reportPathRepository = reportPathRepository;
        this.employeeService = employeeService;
    }

    public ReportPathRepository getReportPathRepository() {
        return reportPathRepository;
    }

    public void setReportPathRepository(ReportPathRepository reportPathRepository) {
        this.reportPathRepository = reportPathRepository;
    }
    public Integer addReportPath() {
        logger.info("Was invoked method to add report with path to DB");
        Integer i = 0;
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            String json = objectMapper.writeValueAsString(employeeService.getReport());
            ReportPathDTO reportPathDTO = new ReportPathDTO();
            File file = new File("report.json");
            Files.writeString(file.toPath(), json);
            reportPathDTO.setPath(file.getAbsolutePath());
            i = reportPathRepository.save(reportPathDTO.toReportPath()).getId();
            logger.debug("Report was adding to DB with id", i);
        } catch (IOException e) {
            logger.error("Error to save the report", e);
        }
        return i;
    }

    @Override
    public ResponseEntity<Resource> getReportPathById(Integer id) {
        logger.info("Was invoked method for getting report with path to DB with id", id);
        ReportPathDTO reportWithPathDTO = ReportPathDTO.fromReportPath(reportPathRepository.findById(id).orElseThrow(() -> {
            IllegalArgumentException e =new IllegalArgumentException("Неверный ID");
            logger.error("Received invalid id",id, e);
            return e;
        }));
        String fileName = "report.json";
        String path = reportWithPathDTO.getPath();
        File file = new File(path);
        Resource resource = new PathResource(file.getPath());
        logger.debug("Received the report with path", reportWithPathDTO);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileName + "\"")
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .body(resource);
    }
}