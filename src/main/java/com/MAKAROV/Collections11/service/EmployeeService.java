package com.MAKAROV.Collections11.service;
import com.MAKAROV.Collections11.exception.EmployeeAlreadyAddedException;
import com.MAKAROV.Collections11.exception.EmployeeNotFoundException;
import com.MAKAROV.Collections11.exception.EmployeeStorageIsFullException;
import com.MAKAROV.Collections11.models.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class EmployeeService {
    private final List<Employee> employees = new ArrayList<>();
    private final int MAX_SIZE = 2;

    public EmployeeService() {
        employees.add(new Employee("Ivan", "Ivaniv", 1, "III", 1999, 1));
        employees.add(new Employee("Qlavdiya", "Qvlavdievna", 2, "QQQ", 2999, 2));
        employees.add(new Employee("Wershin", "Wershinin", 3, "WWW", 3999, 3));
        employees.add(new Employee("Egor", "Egorov", 4, "EEE", 4999, 1));
        employees.add(new Employee("Fillip", "Filipov", 5, "FFF", 3999, 3));
        employees.add(new Employee("Ggor", "Gorov", 6, "GGG", 9999, 2));
    }


    public Employee add(String firstName, String lastName,int id ,String fio ,int salary,int department) {
        if (employees.size() >= MAX_SIZE) {
            throw new EmployeeStorageIsFullException(" переполнен");
        }

        Employee newEmployee = new Employee(firstName, lastName, id , fio ,salary , department);

        if (employees.contains(newEmployee)) {
            throw new EmployeeAlreadyAddedException(newEmployee + " существует");
        }

        employees.add(newEmployee);
        return newEmployee;
    }

    public Employee find(String firstName, String lastName,int id ,String fio ,int salary,int department) {
        Employee employeeForFind = new Employee(firstName, lastName, id , fio ,salary , department);

        if (!employees.contains(employeeForFind)) {
            throw new EmployeeNotFoundException("не найден");
        }

        return employees.get(employees.indexOf(employeeForFind));
    }

    public Employee remove(String firstName, String lastName,int id ,String fio ,int salary,int department) {
        Employee employeeForRemove = new Employee(firstName, lastName, id , fio ,salary , department);

        if (!employees.contains(employeeForRemove)) {
            throw new EmployeeNotFoundException("не найден");
        }

        employees.remove(employeeForRemove);
        return employeeForRemove;
    }

    public List<Employee> getAll() {
        return employees;
    }
}
