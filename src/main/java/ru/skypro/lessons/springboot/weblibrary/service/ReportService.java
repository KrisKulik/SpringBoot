package ru.skypro.lessons.springboot.weblibrary.service;

import ru.skypro.lessons.springboot.weblibrary.dto.ReportDTO;

public interface ReportService {
    Integer addReport(ReportDTO reportDTO);
    ReportDTO getReportById(Integer id);
}