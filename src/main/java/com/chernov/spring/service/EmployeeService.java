package com.chernov.spring.service;

import com.chernov.spring.entity.Employee;

import java.util.List;

public interface EmployeeService {

    public List<Employee> getAllEmployees();

    public void addNewEmployee(Employee employee);

    public Employee getEmployee(int id);

    public void deleteEmployee(int id);

}
