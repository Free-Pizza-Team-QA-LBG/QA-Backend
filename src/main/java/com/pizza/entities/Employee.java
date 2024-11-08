package com.pizza.entities;

import jakarta.persistence.*;
import org.checkerframework.common.aliasing.qual.Unique;
import org.json.JSONObject;

import java.math.BigDecimal;

@Table(name = "employees")
@Entity
public class Employee implements Comparable<Employee> {

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
    private Role role = Role.DEFAULT_ROLE;


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

    public Role getRole() {

        if (role == null)
            role = Role.DEFAULT_ROLE;

        return role;
    }


    public boolean setFirstName(String firstName) {
        this.firstName = firstName;
        return true;
    }

    public boolean setLastName(String lastName) {
        this.lastName = lastName;
        return true;
    }

    public boolean setEmail(String email) {
        this.email = email;
        return true;
    }

    public boolean setDepartment(String department) {
        this.department = department;
        return true;
    }

    public boolean setSalary(BigDecimal salary) {

        if (salary.compareTo(getRole().getMinSalary()) < 0) return false;
        if (salary.compareTo(getRole().getMaxSalary()) > 0) return false;

        this.salary = salary;
        return true;
    }

    public boolean setRole(Role roleID) {
        this.role = roleID;
        return true;
    }

    public JSONObject toJSON() {
        JSONObject employeeJson = new JSONObject();
        employeeJson.put("id", getId());
        employeeJson.put("firstName", getFirstName());
        employeeJson.put("lastName", getLastName());
        employeeJson.put("email", getEmail());
        employeeJson.put("department", getDepartment());
        employeeJson.put("salary", getSalary());
        employeeJson.put("roleID", getRole().getId());

        return employeeJson;
    }

    @Override
    public String toString() {
        return toJSON().toString();
    }


    @Override
    public int compareTo(Employee o) {
        return Integer.compare(getId(), o.getId());
    }
}
