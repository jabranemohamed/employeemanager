package org.mhj.employeemanager.service;

import org.mhj.employeemanager.model.Employee;
import org.mhj.employeemanager.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee addEmployee(Employee employee) {
        employee.setId(UUID.randomUUID());
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return employeeRepository.save(employee);
    }

    public List<Employee> findAllEmployee() {
        return employeeRepository.findAll();
    }

    public Employee updateEmployee(Employee employee){
        return employeeRepository.save(employee);
    }

    public Employee findEmployeeById(String id){
        UUID uuid = UUID.fromString(id);
        return employeeRepository.findEmployeeById(uuid)
                .orElseThrow(()->new UserNotFoundException("User by id "+id + " was not found"));
    }

    public void deleteEmployee(String id){
        UUID uuid = UUID.fromString(id);
        employeeRepository.deleteEmployeeById(uuid);
    }
}
