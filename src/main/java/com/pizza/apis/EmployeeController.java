package com.pizza.apis;


import com.pizza.entities.Employee;
import com.pizza.services.EmployeeService;
import org.apache.tomcat.util.json.JSONParser;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Iterator;

@RestController
@RequestMapping("/api/v1/employee")
class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    // Response: JSON Object containing data (JSON Object)
    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getAllEmployees() {
        JSONObject jsonResponse = new JSONObject();

        JSONArray employeesArray = new JSONArray();
        employeeService.getEmployees().forEach(employee -> employeesArray.put(employee.toJSON()));
        jsonResponse.put("data", employeesArray);

        return ResponseEntity.ok(jsonResponse.toString());
    }

    // Response: JSON Object containing success (boolean) and data (JSON Object)
    @PostMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> addEmployee(@RequestBody Employee employee) {
        Employee createdEmployee = employeeService.addEmployee(employee);

        JSONObject jsonResponse = new JSONObject();
        jsonResponse.put("success", true);
        jsonResponse.put("data", createdEmployee.toJSON());

        return ResponseEntity.ok(jsonResponse.toString());
    }

    // Response: JSON Object containing success (boolean) and data (JSON Object) if success=true or error (text) if success = false
    @PatchMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> updateEmployee(@PathVariable int id, @RequestBody Employee updatedUser) {
        try {
            Employee user = employeeService.updateEmployee(id, updatedUser);

            JSONObject jsonResponse = new JSONObject();
            jsonResponse.put("success", true);
            jsonResponse.put("data", user.toJSON());

            return ResponseEntity.ok(jsonResponse.toString());
        } catch (RuntimeException e) {
            JSONObject jsonResponse = new JSONObject();
            jsonResponse.put("success", false);
            jsonResponse.put("error", e.getMessage());

            return ResponseEntity.status(404).body(jsonResponse.toString());
        }
    }

    // Response: JSON Object containing success (boolean) and message (text)
    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> delete(@PathVariable int id) {
        try {
            employeeService.deleteUserById(id);

            JSONObject jsonResponse = new JSONObject();
            jsonResponse.put("success", true);
            jsonResponse.put("message", "Employee deleted successfully.");

            return ResponseEntity.ok(jsonResponse.toString());
        } catch (RuntimeException e) {
            JSONObject jsonResponse = new JSONObject();
            jsonResponse.put("success", false);
            jsonResponse.put("error", e.getMessage());

            return ResponseEntity.status(404).body(jsonResponse.toString());
        }
    }


}
