package com.pizza.apis;


import org.apache.tomcat.util.json.JSONParser;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.*;

import java.util.Iterator;

@RestController
@RequestMapping("/api/v1/employee")
class EmployeeController {

    @GetMapping("/{id}")
    public String greetEmployee(@PathVariable int id) {
        System.out.printf("SOMETHING HAPPENED to %d\n", id);
        return "Hello Employee " + id;
    }

    @PostMapping("")
    public String test(@RequestBody String s) {

        //System.out.println("Flipping request");
        JSONObject body = new JSONObject(s);
        //System.out.println(body);
        //System.out.println("Dough balled.");

        return body.toString();

    }

}
