package com.pizza.services;

import com.pizza.repos.EmployeeRepo;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.stream.Stream;

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


        return new JSONObject("{\"employees\":" +
                new JSONArray(
                        Stream.of(employeeRepo.findAll().toArray())
                                .map(Objects::toString)
                                .toArray()
                ) + "}"
        ).toString();

    }

}
