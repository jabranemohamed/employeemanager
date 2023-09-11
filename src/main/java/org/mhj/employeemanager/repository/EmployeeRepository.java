package org.mhj.employeemanager.repository;

import org.mhj.employeemanager.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    void deleteEmployeeById(UUID id);

    Optional<Employee> findEmployeeById(UUID id);
}
