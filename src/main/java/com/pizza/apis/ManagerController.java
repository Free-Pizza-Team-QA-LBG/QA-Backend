package com.pizza.apis;

import com.pizza.services.ManagerService;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/manager")
public class ManagerController {

    @Autowired
    private ManagerService managerService;

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getAllEmployees() {

        JSONObject jsonResponse = new JSONObject();
        JSONArray managersArray = new JSONArray();

        managerService.getAll().forEach(manager -> managersArray.put(manager.toJSON()));
        jsonResponse.put("data", managersArray);

        return ResponseEntity.ok(jsonResponse.toString());
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getByManagerID(@PathVariable int id) {

        JSONObject jsonResponse = new JSONObject();
        JSONArray managersArray = new JSONArray();

        managerService.getByManagerId(id).forEach(manager -> managersArray.put(manager.toJSON()));
        jsonResponse.put("data", managersArray);

        return ResponseEntity.ok(jsonResponse.toString());
    }

}
