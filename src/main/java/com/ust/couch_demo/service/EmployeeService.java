package com.ust.couch_demo.service;

import com.ust.couch_demo.model.Employee;
import com.ust.couch_demo.repo.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    public List<Employee> getAllEmployees() {
        return repository.getAll();
    }

    public Employee getEmployee(String id) {
        return repository.get(id);
    }

    public void addEmployee(Employee employee) {
        repository.add(employee);
    }

    public void updateEmployee(Employee employee) {
        repository.update(employee);
    }

    public void deleteEmployee(String id) {
        Employee employee = repository.get(id);
        repository.remove(employee);
    }
}
