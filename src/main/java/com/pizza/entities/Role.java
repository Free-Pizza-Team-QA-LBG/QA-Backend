package com.pizza.entities;

import jakarta.persistence.*;
import org.checkerframework.common.aliasing.qual.Unique;
import org.json.JSONObject;

import java.math.BigDecimal;

@Table(name = "roles")
@Entity
public class Role {

    public final static Role DEFAULT_ROLE = new Role();
    static {
        DEFAULT_ROLE.setId(1);
        DEFAULT_ROLE.setRoleName("Default");
        DEFAULT_ROLE.setMaxSalary(new BigDecimal(10000000000L));
        DEFAULT_ROLE.setMinSalary(new BigDecimal(0L));
    }

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Unique
    @Column(name = "role_name")
    private String roleName;

    @Column(name = "min_salary")
    private BigDecimal minSalary;

    @Column(name = "max_salary")
    private BigDecimal maxSalary;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public BigDecimal getMinSalary() {
        return minSalary;
    }

    public void setMinSalary(BigDecimal minSalary) {
        this.minSalary = minSalary;
    }

    public BigDecimal getMaxSalary() {
        return maxSalary;
    }

    public void setMaxSalary(BigDecimal maxSalary) {
        this.maxSalary = maxSalary;
    }

    public JSONObject toJSON() {
        JSONObject roleJson = new JSONObject();
        roleJson.put("id", getId());
        roleJson.put("roleName", getRoleName());
        roleJson.put("minSalary", getMinSalary());
        roleJson.put("maxSalary", getMaxSalary());

        return roleJson;
    }

    @Override
    public String toString() {
        return toJSON().toString();
    }
}
