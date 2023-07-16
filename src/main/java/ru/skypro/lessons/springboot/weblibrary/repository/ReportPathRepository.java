package ru.skypro.lessons.springboot.weblibrary.repository;

import org.springframework.data.repository.CrudRepository;
import ru.skypro.lessons.springboot.weblibrary.pojo.ReportPath;

import java.util.List;
import java.util.Optional;

public interface ReportPathRepository extends CrudRepository<ReportPath, Integer> {

    List<ReportPath> findAll();

    @Override
    Optional<ReportPath> findById(Integer integer);
}