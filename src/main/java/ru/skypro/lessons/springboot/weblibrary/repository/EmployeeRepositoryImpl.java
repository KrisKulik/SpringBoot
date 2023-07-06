//package ru.skypro.lessons.springboot.weblibrary.repository;
//
//import org.springframework.stereotype.Repository;
//import ru.skypro.lessons.springboot.weblibrary.pojo.Employee;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//@Repository
//public class EmployeeRepositoryImpl implements EmployeeRepository{
//    private final List <Employee> employeeList = new ArrayList<>(List.of(
//            new Employee("Harry", 100_000),
//            new Employee("Hermione", 200_000),
//            new Employee("Ron", 80_000),
//            new Employee("Draco", 140_000),
//            new Employee("Neville", 110_000))
//    );
//
//    @Override
//    public List<Employee> getAllEmployees() {
//        return employeeList ;
//    }
//
//    @Override
//    public Employee addEmployees(Employee employee) {
//        employeeList.add(employee);
//        return employee;
//    }
//
//    @Override
//    public void editEmployee(int id, Employee employee) {
//        int index = -1;
//        for (int i = 0; i < employeeList.size(); i++) {
//            if (employeeList.get(i).getId() == id) {
//                index = i;
//                break;
//            }
//        }
//        if (index != -1) {
//            employeeList.set(index, employee);
//        }
//    }
//
//
//    @Override
//    public void deleteEmployee(int id) {
//        int index = -1;
//        for (int i = 0; i < employeeList.size(); i++) {
//            if (employeeList.get(i).getId() == id) {
//                index = i;
//                break;
//            }
//        }
//        if (index != -1) {
//            employeeList.remove(index);
//        }
//    }
//
//
//    @Override
//    public Optional<Employee> findById(int id) {
//        return employeeList.stream().filter(employee -> employee.getId() == id).findFirst();
//    }
//
//}
