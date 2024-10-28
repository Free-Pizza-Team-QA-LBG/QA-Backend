package com.pizza;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.assertTrue;

@SpringBootTest
class PizzaBackendTests {

    @Test
    void contextLoads() {

    }

    //jdt test functions
    @Test
    void alwaysTrue(){
        Assertions.assertTrue(true);
    }

    @Test
    void alwaysFalse(){
        Assertions.assertTrue(false);
    }

}
