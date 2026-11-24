package org.example.fullstackcrud.controller;

import org.example.fullstackcrud.entity.Employee;
import org.example.fullstackcrud.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class EmployeeController {
    private final EmployeeService employeeService;
    public  EmployeeController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }
    @PostMapping
    public ResponseEntity<Employee> create(@RequestBody Employee employee){
        Employee created = employeeService.createEmployee(employee);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @GetMapping
    public ResponseEntity<List<Employee>> getAll(){
        return  ResponseEntity.ok(employeeService.getAllEmployees());
    }

    @GetMapping("/{id}")
    public  ResponseEntity<Employee> getEmpById(@PathVariable Long id){
        return  ResponseEntity.ok(employeeService.getEmployeeById(id));
    }
    @PutMapping("/{id}")
    public ResponseEntity<Employee> update(@PathVariable Long id, @RequestBody Employee employee){
        return  ResponseEntity.ok(employeeService.updateEmployee(id, employee));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        employeeService.deleteEmployee(id);
        return  ResponseEntity.noContent().build();
    }
}
