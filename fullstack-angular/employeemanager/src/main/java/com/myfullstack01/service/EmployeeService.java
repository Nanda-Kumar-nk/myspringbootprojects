package com.myfullstack01.service;

import com.myfullstack01.exception.UserNotFoundException;
import com.myfullstack01.model.Employee;
import com.myfullstack01.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EmployeeService {
    private final EmployeeRepo employeeRepo;

    @Autowired
    public EmployeeService(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    public Employee addEmployee(Employee newEmployee) {
        newEmployee.setEmployeeCode(UUID.randomUUID().toString());
        return employeeRepo.save(newEmployee);
    }

    public List<Employee> findAllEmployees() {
        return employeeRepo.findAll();
    }

    public Employee updateEmployee(Employee updatedEmployee) {
        return employeeRepo.save(updatedEmployee);
    }

    public void deleteEmployee(Long id) {
        employeeRepo.deleteEmployeeById(id);
    }

    public Employee findEmployeebyId(Long id) throws UserNotFoundException {
        return employeeRepo.findEmployeeById(id)
                .orElseThrow(() -> new UserNotFoundException(String.format("User doesn't exit with id %s", id)));
    }
}
