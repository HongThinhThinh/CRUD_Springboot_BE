package com.example.CRUD_SPRINGBOOT.controller;


import com.example.CRUD_SPRINGBOOT.exception.EmPloyeeNotFoundException;
import com.example.CRUD_SPRINGBOOT.model.Employee;
import com.example.CRUD_SPRINGBOOT.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:3000")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    //getallEmployee

    @GetMapping("/employees")
    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }

    @PostMapping("/addEmployees")
    String newEmployee(@RequestBody Employee newEmployee) {
        System.out.println(newEmployee.toString());
        employeeRepository.save(newEmployee);
        return "thành công";
    }

    @GetMapping("/employees/{id}")
    Employee getEmployeeByID(@PathVariable Long id) {
        return employeeRepository.findById(id).orElseThrow(() -> new EmPloyeeNotFoundException(id));
    }

    @PutMapping("/employees/{id}")
    public Employee updateEmployee(@RequestBody Employee newEmployee, @PathVariable Long id) {
        System.out.println("hi: " +id);
        System.out.println(newEmployee.toString());
         Employee existingEmp = employeeRepository.findById(id)
                .orElseThrow(() -> new EmPloyeeNotFoundException(id));
        existingEmp.setEmailID(newEmployee.getEmailID());
        existingEmp.setFirstName(newEmployee.getFirstName());
        existingEmp.setLastName(newEmployee.getLastName());
        return employeeRepository.save(existingEmp);
    }

    @DeleteMapping("/employees/{id}")
    String deleteEmployees(@PathVariable Long id) {
        if (!employeeRepository.existsById(id)) {
            throw new EmPloyeeNotFoundException(id);
        }
        employeeRepository.deleteById(id);
        return "user with id :" + id + "has been deleted successfully";
    }
}
