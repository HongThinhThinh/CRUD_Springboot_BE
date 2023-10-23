package com.example.CRUD_SPRINGBOOT.repository;


import com.example.CRUD_SPRINGBOOT.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {

}
