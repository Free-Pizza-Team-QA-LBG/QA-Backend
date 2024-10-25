package com.pizza.apis;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;
import java.util.random.RandomGenerator;


/**
 * Heartbeat ping class
 * No other effects, may be extended to read internal status and return such
 * @author BenSnellgrove
 * @version 25/10/2024
 */
@RestController
@RequestMapping("/api/v1/heartbeat")
public class HeartBeatController {

    private final RandomGenerator GENERATOR = new Random();
    private final String[] HEARTBEAT_RESPONSES = new String[]{
            "{\"crust\": \"stuffed\"}",
            "{\"dough\": \"balled\"}",
            "{\"mo-jo\": \"dough-jo\"}",
            "{\"cheese\": \"grated\"}",
            "{\"pepper\": \"on(i)\"}"
    };

    /**
     * Heartbeat ping
     * @return 200 always (none if dead) and a light-hearted message
     */
    @GetMapping("")
    public ResponseEntity<String> heartBeat() {

        return new ResponseEntity<>(
                HEARTBEAT_RESPONSES[GENERATOR.nextInt(HEARTBEAT_RESPONSES.length)],
                HttpStatus.OK);

    }

}
