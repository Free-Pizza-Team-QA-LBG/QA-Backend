package com.pizza.services;

import com.pizza.repos.EmployeeRepo;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;

    public String getEmployees() {

//        for (Object s: Stream.of(employeeRepo.findAll().toArray())
//                .map(Objects::toString)
//                .toArray()
//             ) {
//
//            System.out.println(s);
//
//        }
//
//
//        System.out.println(new JSONObject("{\"employees\":" +
//                new JSONArray(
//                        Stream.of(employeeRepo.findAll().toArray())
//                                .map(Objects::toString)
//                                .toArray()
//                ) + "}"
//        ));

        JSONArray employeesArray = new JSONArray();
        employeeRepo.findAll().forEach(employee -> {
            JSONObject employeeJson = new JSONObject();
            employeeJson.put("id", employee.getId());
            employeeJson.put("firstName", employee.getFirstName());
            employeeJson.put("lastName", employee.getLastLame());
            employeeJson.put("email", employee.getEmail());
            employeeJson.put("department", employee.getDepartment());
            employeeJson.put("salary", employee.getSalary());

            employeesArray.put(employeeJson);
        });

        JSONObject jsonResult = new JSONObject();
        jsonResult.put("employees", employeesArray);

        return jsonResult.toString();
    }

    public void deleteUserById(int userId) {
        if (employeeRepo.existsById(userId)) {
            employeeRepo.deleteById(userId);
        } else {
            throw new RuntimeException("User not found with ID: " + userId);
        }
    }

}
