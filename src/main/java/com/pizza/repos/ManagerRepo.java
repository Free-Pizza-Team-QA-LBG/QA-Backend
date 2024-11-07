package com.pizza.repos;

import com.pizza.entities.Employee;
import com.pizza.entities.Manager;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManagerRepo extends JpaRepository<Manager, Integer> {
}
