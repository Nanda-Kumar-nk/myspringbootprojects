package com.myfullstack01.repo;

import com.myfullstack01.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {

    // Query method for deletion
    void deleteEmployeeById(Long id);

    // Query method for read
    Optional<Employee> findEmployeeById(Long id);
}
