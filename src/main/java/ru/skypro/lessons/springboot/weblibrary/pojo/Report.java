package ru.skypro.lessons.springboot.weblibrary.pojo;

import jakarta.persistence.*;
@Entity
@Table (name = "report")
public class Report {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id;
        private String file;

    public Report(Integer id, String file) {
        this.id = id;
        this.file = file;
    }

    public Report() {

    }

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
}

