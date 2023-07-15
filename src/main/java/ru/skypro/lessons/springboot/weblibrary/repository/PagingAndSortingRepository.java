package ru.skypro.lessons.springboot.weblibrary.repository;

import ru.skypro.lessons.springboot.weblibrary.pojo.Employee;

public interface PagingAndSortingRepository extends org.springframework.data.repository.PagingAndSortingRepository <Employee, Integer> {
}
