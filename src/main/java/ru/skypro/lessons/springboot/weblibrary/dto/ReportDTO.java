package ru.skypro.lessons.springboot.weblibrary.dto;

import ru.skypro.lessons.springboot.weblibrary.pojo.Report;

import java.io.Serializable;

public class ReportDTO implements Serializable {
    private Integer id;
    private String file;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public static ReportDTO fromReport(Report report) {
        ReportDTO reportDTO = new ReportDTO();
        reportDTO.setId(report.getId());
        reportDTO.setFile(report.getFile());
        return reportDTO;
    }

    public Report toReport() {
        Report report = new Report();
        report.setId(this.getId());
        report.setFile(this.getFile());
        return report;
    }
}