package ru.skypro.lessons.springboot.weblibrary.service;

import ru.skypro.lessons.springboot.weblibrary.dto.ReportPathDTO;

public interface ReportPathService {
        Integer addReportPath(ReportPathDTO reportPathDTO);
        ReportPathDTO getReportPathById(Integer id);
    }

