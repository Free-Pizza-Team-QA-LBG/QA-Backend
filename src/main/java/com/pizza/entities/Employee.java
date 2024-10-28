package com.pizza.entities;

import jakarta.persistence.*;
import org.checkerframework.common.aliasing.qual.Unique;

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

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastLame() {
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

    @Override
    public String toString() {
        return String.format("{" +
                "'id':%d," +
                "'first_name':'%s'," +
                "'last_name':'%s'," +
                "'email':'%s'," +
                "'department':'%s'," +
                "'salary':%.2f" +
                "}",
                id, firstName, lastName, email, department, salary);
    }
}
