package ru.skypro.lessons.springboot.weblibrary.pojo;

public class Employee {
    private String name;
    private int salary;
    private static int idGeneration = 1;
    private int id;

    public Employee(String name, int salary) {
        this.name = name;
        this.salary = salary;
        this.id = idGeneration++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                ", idGeneration=" + idGeneration +
                ", id=" + id +
                '}';
    }
}
