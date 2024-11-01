package com.pizza;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PizzaBackend {
    // tken
    public static void main(String[] args) {
        System.out.printf("Loading pizza backend\n\n");
        SpringApplication.run(PizzaBackend.class, args);

    }
}
