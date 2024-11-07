package com.pizza.entities;

import jakarta.persistence.*;
import org.json.JSONObject;

import java.io.Serializable;

@Embeddable
public class ManagerID implements Serializable {

    @JoinColumn(name = "manager_id", nullable = false)
    @ManyToOne
    private Employee manager;

    @JoinColumn(name = "employee_id", nullable = false)
    @ManyToOne
    private Employee employee;

    public Employee getManager() {
        return manager;
    }

    public void setManager(Employee manager) {
        this.manager = manager;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public JSONObject toJSON() {
        JSONObject employeeJson = new JSONObject();
        employeeJson.put("managerID", manager.getId());
        employeeJson.put("employeeID", employee.getId());

        return employeeJson;
    }

    @Override
    public String toString() {
        return toJSON().toString();
    }

}