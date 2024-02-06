package com.crudDemorest.crudDemo.dao;

import com.crudDemorest.crudDemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
    // no need to write anything and impl class...
}
