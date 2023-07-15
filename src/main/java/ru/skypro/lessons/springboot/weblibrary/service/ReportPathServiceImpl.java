package ru.skypro.lessons.springboot.weblibrary.service;

import org.springframework.stereotype.Service;
import ru.skypro.lessons.springboot.weblibrary.dto.ReportPathDTO;
import ru.skypro.lessons.springboot.weblibrary.repository.ReportPathRepository;
@Service
public class ReportPathServiceImpl implements ReportPathService {

    private ReportPathRepository reportPathRepository;

    public ReportPathServiceImpl(ReportPathRepository reportPathRepository) {
        this.reportPathRepository = reportPathRepository;
    }

    public ReportPathRepository getReportPathRepository() {
        return reportPathRepository;
    }

    public void setReportPathRepository(ReportPathRepository reportPathRepository) {
        this.reportPathRepository = reportPathRepository;
    }
    public Integer addReportPath(ReportPathDTO reportWithPathDTO) {
        return reportPathRepository.save(reportWithPathDTO.toReportPath()).getId();
    }

    @Override
    public ReportPathDTO getReportPathById(Integer id) {
        return ReportPathDTO.fromReportPath(reportPathRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("Неверный ID")));
    }
}