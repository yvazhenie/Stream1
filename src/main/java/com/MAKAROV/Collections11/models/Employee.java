package com.MAKAROV.Collections11.models;

import java.util.Objects;

public class Employee {

    private final String firstName;
    private final String lastName;
    private final int id;
    private final String fio;
    private final int salary;
    private final Integer department;


    public Employee(String firstName, String lastName, int id, String fio, int salary, Integer department) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
        this.fio = fio;
        this.salary = salary;
        this.department = department;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getId() {
        return id;
    }

    public String getFio() {
        return fio;
    }

    public int getSalary() {
        return salary;
    }

    public Integer getDepartment() {
        return department;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id && salary == employee.salary && department == employee.department && Objects.equals(firstName, employee.firstName) && Objects.equals(lastName, employee.lastName) && Objects.equals(fio, employee.fio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, id, fio, salary, department);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", id=" + id +
                ", fio='" + fio + '\'' +
                ", salary=" + salary +
                ", department=" + department +
                '}';
    }
}
