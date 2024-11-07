package com.pizza.services;

import com.pizza.repos.ManagerRepo;
import com.pizza.repos.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManagerService {

    @Autowired
    private ManagerRepo managerRepo;

}
