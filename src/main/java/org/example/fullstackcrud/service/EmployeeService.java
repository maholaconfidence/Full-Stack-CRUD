package org.example.fullstackcrud.service;

import org.example.fullstackcrud.entity.Employee;
import org.example.fullstackcrud.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    private  final EmployeeRepository employeeRepository;
    public  EmployeeService(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }
    //CREATE
    public Employee createEmployee(Employee employee){
        return employeeRepository.save(employee);
    }
    //READ ALL
    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }
    //READ ONE
    public  Employee getEmployeeById(Long id){
        return employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("Employee not found with id: " + id));
    }
//UPDATE
    public Employee updateEmployee(Long id, Employee updatedDetails){
        Employee existing = getEmployeeById(id);
        existing.setFirstName(updatedDetails.getFirstName());
        existing.setLastName(updatedDetails.getLastName());
        existing.setEmail(updatedDetails.getEmail());
        return employeeRepository.save(existing);
    }
    //DELETE
    public  void deleteEmployee(Long id){
        Employee existing = getEmployeeById(id);
        employeeRepository.delete(existing);
    }
}
