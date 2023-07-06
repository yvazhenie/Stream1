package com.MAKAROV.Collections11.service;

import com.MAKAROV.Collections11.exception.EmployeeNotFoundException;
import com.MAKAROV.Collections11.models.Employee;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class DepartmentService {
    private final EmployeeService employeeService;

    public DepartmentService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public Employee maxSalary(int department) {
        List<Employee> employees = employeeService.getAll();
        return employees.stream()
                .filter(e ->e.getDepartment() == department)
                .max(Comparator.comparing(Employee::getSalary))
                .orElseThrow(() -> new EmployeeNotFoundException("не найден сотрудник"));

    }
    public Employee minSalary(int department) {
        List<Employee> employees = employeeService.getAll();
        return employees.stream()
                .filter(e ->e.getDepartment() == department)
                .min(Comparator.comparing(Employee::getSalary))
                .orElseThrow(() -> new EmployeeNotFoundException("не найден сотрудник"));

    }
    public Map<Integer, List<Employee>>  employeesByDepartment (Integer department) {
        List<Employee> employees = employeeService.getAll();
        return employees.stream()
                .filter(e -> department == null || e.getDepartment().equals(department))
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.toList()));
    }
}
