package ua.doc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.doc.exception.ResourceNotFoundException;
import ua.doc.model.Employee;
import ua.doc.repo.EmployeeRepository;

import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee) {
        return employeeRepository.save(employee);
    }

    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> findAll() {
        return ResponseEntity.ok(employeeRepository.findAll());
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> findEmployeeById(@PathVariable(value = "id") Integer id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Employee with id = " + id + " not exist")
        );
        return ResponseEntity.ok().body(employee);
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteEmployee(@PathVariable(value = "id") Integer id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Employee with id = " + id + " not exist")
        );
        employeeRepository.delete(employee);
        return ResponseEntity.ok().build();
    }
}
