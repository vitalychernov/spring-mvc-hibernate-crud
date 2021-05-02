package com.chernov.spring.dao;

import com.chernov.spring.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Employee> getAllEmployees() {

        Session session = sessionFactory.getCurrentSession();

        List<Employee> employees = session.createQuery("from Employee ", Employee.class)
                .getResultList();

        return employees;
    }

    @Override
    public void addNewEmployee(Employee employee) {

        Session session = sessionFactory.getCurrentSession();

        session.saveOrUpdate(employee);
    }

    @Override
    public Employee getEmployee(int id) {

        Session session = sessionFactory.getCurrentSession();

        Employee employee = session.get(Employee.class, id);

        return employee;
    }

    @Override
    public void deleteEmployee(int id) {

        Session session = sessionFactory.getCurrentSession();

        Employee employee = session.get(Employee.class, id);

        session.delete(employee);
    }
}
