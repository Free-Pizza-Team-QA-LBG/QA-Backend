package com.pizza.entities;

import jakarta.persistence.*;
import org.checkerframework.common.aliasing.qual.Unique;
import org.json.JSONObject;

import java.math.BigDecimal;

@Table(name = "employees")
@Entity
public class Employee {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;


    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")

    private String lastName;

    @Unique
    private String email;

    private String department;

    private BigDecimal salary;

    @JoinColumn(name = "role_id")
    @ManyToOne
    private Role role;

    public Role getRole() {
        return role;
    }

    public void setRole(Role roleID) {
        this.role = roleID;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getDepartment() {
        return department;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setSalary(BigDecimal salary) {
        // TODO check if between min and max salary of role
        this.salary = salary;
    }

    public JSONObject toJSON() {
        JSONObject employeeJson = new JSONObject();
        employeeJson.put("id", getId());
        employeeJson.put("firstName", getFirstName());
        employeeJson.put("lastName", getLastName());
        employeeJson.put("email", getEmail());
        employeeJson.put("department", getDepartment());
        employeeJson.put("salary", getSalary());
        employeeJson.put("roleID", role.getId());

        return employeeJson;
    }

    @Override
    public String toString() {
        return toJSON().toString();
    }
}
