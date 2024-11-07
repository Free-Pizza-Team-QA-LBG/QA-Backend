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

        if (managerRepo.findById(id).isPresent())
            out.add(managerRepo.findById(id).get());

        return out;
    }

}
