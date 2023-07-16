package ru.skypro.lessons.springboot.weblibrary.service;

import org.springframework.stereotype.Service;
import ru.skypro.lessons.springboot.weblibrary.dto.ReportDTO;
import ru.skypro.lessons.springboot.weblibrary.repository.ReportRepository;
@Service
public class ReportServiceImpl implements ReportService {
   private final ReportRepository reportRepository;

    public ReportServiceImpl(ReportRepository reportRepository) {
        this.reportRepository = reportRepository;
    }


    @Override
    public Integer addReport(ReportDTO reportDTO) {
        return reportRepository.save(reportDTO.toReport()).getId();
    }

    @Override
    public ReportDTO getReportById(Integer id) {
        return ReportDTO.fromReport(reportRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("Неверный ID")));
    }
}

