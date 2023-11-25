package com.developerex.server;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingsController {

        @GetMapping("/greet")
        public String greet() {
            return "Hello, World";
        }
}
