package com.ust.couch_demo.controller;

import com.ust.couch_demo.model.Employee;
import com.ust.couch_demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @GetMapping
    public List<Employee> getAllEmployees() {
        return service.getAllEmployees();
    }

    @GetMapping("/{id}")
    public Employee getEmployee(@PathVariable String id) {
        return service.getEmployee(id);
    }

    @PostMapping
    public void addEmployee(@RequestBody Employee employee) {
        service.addEmployee(employee);
    }

    @PutMapping("/{id}/{rev}")
    public void updateEmployee(@PathVariable String id,@PathVariable String rev, @RequestBody Employee employee) {
        employee.setId(id); // ensure the id is set
        employee.setRevision(rev);
        service.updateEmployee(employee);
    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable String id) {
        service.deleteEmployee(id);
    }
}
