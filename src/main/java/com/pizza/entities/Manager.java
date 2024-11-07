package com.pizza.entities;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import org.json.JSONObject;

@Table(name = "managers")
@Entity
public class Manager {
    @EmbeddedId
    private ManagerID id;

    public ManagerID getId() {
        return id;
    }

    public void setId(ManagerID id) {
        this.id = id;
    }

    public JSONObject toJSON() {
        return id.toJSON();
    }

    @Override
    public String toString() {
        return toJSON().toString();
    }

}
