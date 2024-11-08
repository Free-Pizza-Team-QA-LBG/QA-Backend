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

    public boolean setManager(Employee manager) {
        if (manager == this.employee) return false;

        this.manager = manager;
        return true;
    }

    public Employee getEmployee() {
        return employee;
    }

    public boolean setEmployee(Employee employee) {
        if (employee == this.manager) return false;

        this.employee = employee;
        return true;
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