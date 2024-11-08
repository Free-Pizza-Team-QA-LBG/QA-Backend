package com.pizza.services;

import com.pizza.entities.Employee;
import com.pizza.repos.EmployeeRepo;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;

    public List<Employee> getEmployees() {
        return employeeRepo.findAll();
    }

    public void deleteUserById(int employeeId) {
        if (employeeRepo.existsById(employeeId)) {
            employeeRepo.deleteById(employeeId);
        } else {
            throw new RuntimeException("User not found with ID: " + employeeId);
        }
    }

    public Employee updateEmployee(int employeeId, Employee updatedEmployee) {
        Optional<Employee> existingEmployee = employeeRepo.findById(employeeId);
        if (existingEmployee.isPresent()) {
            Employee employee = existingEmployee.get();
            employee.setFirstName(updatedEmployee.getFirstName());
            employee.setLastName(updatedEmployee.getLastName());
            employee.setEmail(updatedEmployee.getEmail());
            employee.setDepartment(updatedEmployee.getDepartment());
            employee.setSalary(updatedEmployee.getSalary());
            return employeeRepo.save(employee);
        } else {
            throw new RuntimeException("User not found with ID: " + employeeId);
        }
    }

    public Employee addEmployee(Employee employee) {

        // Validation
        Employee validated = new Employee();
        if (
                !(
                        validated.setFirstName(employee.getFirstName()) &&
                        validated.setLastName(employee.getLastName()) &&
                        validated.setEmail(employee.getEmail()) &&
                        validated.setDepartment(employee.getDepartment()) &&
                        validated.setSalary(employee.getSalary()) &&
                        validated.setRole(employee.getRole())
                )
        ) {}


        return employeeRepo.save(employee);
    }

}
