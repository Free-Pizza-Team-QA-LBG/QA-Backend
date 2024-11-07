package com.pizza.services;

import com.pizza.entities.Manager;
import com.pizza.repos.ManagerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ManagerService {

    @Autowired
    private ManagerRepo managerRepo;

    public List<Manager> getAll() {
        return managerRepo.findAll();
    }

    public List<Manager> getByManagerId(int id) {
        List<Manager> out = new ArrayList<>();

        for (Manager manager : managerRepo.findAll()) {
            if (manager.getId().getManager().getId() == id) {
                out.add(manager);
            }
        }

        return out;
    }

    public List<Manager> getByEmployeeId(int id) {
        List<Manager> out = new ArrayList<>();

        for (Manager manager : managerRepo.findAll()) {
            if (manager.getId().getEmployee().getId() == id) {
                out.add(manager);
            }
        }

        return out;
    }

}
