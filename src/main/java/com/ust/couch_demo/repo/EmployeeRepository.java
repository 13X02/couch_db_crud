package com.ust.couch_demo.repo;


import com.ust.couch_demo.model.Employee;
import jakarta.annotation.PostConstruct;
import org.ektorp.CouchDbConnector;
import org.ektorp.support.CouchDbRepositorySupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class EmployeeRepository extends CouchDbRepositorySupport<Employee> {

    @Autowired
    public EmployeeRepository(CouchDbConnector db) {
        super(Employee.class, db);
    }

    @PostConstruct
    public void init() {
        initStandardDesignDocument();
    }
}
