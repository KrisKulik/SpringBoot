package ru.skypro.lessons.springboot.weblibrary.service;

import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;

public interface ReportPathService {
    Integer addReportPath();
    ResponseEntity<Resource> getReportPathById(Integer id);
}

