package ru.skypro.lessons.springboot.weblibrary.repository;

import org.springframework.data.repository.CrudRepository;
import ru.skypro.lessons.springboot.weblibrary.pojo.Report;

import java.util.List;
import java.util.Optional;

public interface ReportRepository extends CrudRepository<Report, Integer> {
    List<Report> findAll();
    @Override
    Optional<Report> findById(Integer integer);
}