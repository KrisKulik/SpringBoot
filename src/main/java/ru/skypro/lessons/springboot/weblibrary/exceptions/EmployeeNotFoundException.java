package ru.skypro.lessons.springboot.weblibrary.exceptions;

public class EmployeeNotFoundException extends RuntimeException{
    private int id;

    public EmployeeNotFoundException(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }
}