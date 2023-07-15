package com.MAKAROV.Collections11.service;
import com.MAKAROV.Collections11.exception.EmployeeAlreadyAddedException;
import com.MAKAROV.Collections11.exception.EmployeeNotFoundException;
import com.MAKAROV.Collections11.exception.EmployeeStorageIsFullException;
import com.MAKAROV.Collections11.exception.InvalidNameException;
import com.MAKAROV.Collections11.models.Employee;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class EmployeeService {
    private final List<Employee> employees = new ArrayList<>();
    private final int MAX_SIZE = 2;


    public Employee add(String firstName, String lastName,int id ,String fio ,int salary,int department) {
        if (employees.size() >= MAX_SIZE) {
            throw new EmployeeStorageIsFullException(" переполнен");
        }
        methodCapitalize(firstName,lastName);
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

    private void methodCapitalize(String firstName, String lastName) {
        String capitalizeFirstName = StringUtils.capitalize(firstName);
        String capitalizeLastName = StringUtils.capitalize(lastName);
        if (!(firstName.equals(capitalizeFirstName))) {
            throw new InvalidNameException("Не правильное имя");
        }
        if (!(lastName.equals(capitalizeLastName))) {
            throw new InvalidNameException("Не правильная фамилия");
        }
    }

    private void methodAlpha(String firstName, String lastName) {
        if (!StringUtils.isAlpha(firstName)) {
            throw new InvalidNameException("ЗАпрещенные символы в имени");
        }
        if (!StringUtils.isAlpha(lastName)) {
            throw new InvalidNameException("Запрещенные символы в фамилии");
        }
    }

}
