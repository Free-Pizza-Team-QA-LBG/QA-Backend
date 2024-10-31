package com.pizza.apis;


import com.pizza.entities.Employee;
import com.pizza.services.EmployeeService;
import org.apache.tomcat.util.json.JSONParser;
import org.json.JSONObject;
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

    @GetMapping("/{id}")
    public String greetEmployee(@PathVariable int id) {
        System.out.printf("SOMETHING HAPPENED to %d\n", id);
        return "Hello Employee " + id;
    }

    @GetMapping("/all")
    public ResponseEntity<String> getAllEmployees() {
        return new ResponseEntity<>(
                employeeService.getEmployees()
                ,
                HttpStatus.OK);
    }

    @PostMapping("")
    public String test(@RequestBody String s) {

        //System.out.println("Flipping request");
        JSONObject body = new JSONObject(s);
        //System.out.println(body);
        //System.out.println("Dough balled.");

        return body.toString();

    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateEmployee(@PathVariable int id, @RequestBody Employee updatedUser) {
        try {
            Employee user = employeeService.updateEmployee(id, updatedUser);
            return ResponseEntity.ok("User updated");
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body(null);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        try {
            employeeService.deleteUserById(id);
            return new ResponseEntity<>("Employee deleted",
                    HttpStatus.OK);
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }


}
