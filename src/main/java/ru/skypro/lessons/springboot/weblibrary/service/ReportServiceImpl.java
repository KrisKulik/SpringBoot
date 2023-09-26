package ru.skypro.lessons.springboot.weblibrary.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.skypro.lessons.springboot.weblibrary.dto.ReportDTO;
import ru.skypro.lessons.springboot.weblibrary.repository.ReportRepository;
@Service
public class ReportServiceImpl implements ReportService {
    private final ReportRepository reportRepository;
    private final EmployeeService employeeService;
    Logger logger = LoggerFactory.getLogger(ReportServiceImpl.class);


    public ReportServiceImpl(ReportRepository reportRepository, EmployeeService employeeService) {
        this.reportRepository = reportRepository;
        this.employeeService = employeeService;
    }


    @Override
    public Integer addReport() {
        logger.info("Was invoked method to add report to DB");
        Integer i = 0;
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            String json = objectMapper.writeValueAsString(employeeService.getReport());
            ReportDTO reportDTO = new ReportDTO();
            reportDTO.setFile(json);
            i = reportRepository.save(reportDTO.toReport()).getId();
            logger.debug("Report added to DB with id", i);
        } catch (JsonProcessingException e) {
            logger.error("Error to save", e);
        }
        return i;
    }

    @Override
    public ResponseEntity<Resource> getReportById(Integer id) {
        logger.info("Was invoked method for getting report to DB with id", id);
        ReportDTO reportDTO = ReportDTO.fromReport(reportRepository.findById(id).orElseThrow(() -> {
            IllegalArgumentException e = new IllegalArgumentException("Неверный ID");
            logger.error("Received incorrect id",id, e);
            return e;
        }));
        String fileName = "report.json";
        String json = reportDTO.getFile();
        Resource resource = new ByteArrayResource(json.getBytes());
        logger.debug("Received the report", reportDTO);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileName + "\"")
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .body(resource);
    }
}

