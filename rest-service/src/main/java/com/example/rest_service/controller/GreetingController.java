package com.example.rest_service.controller;

import com.example.rest_service.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    @Autowired
    GreetingService greetingService;

    @GetMapping("/greeting")
    public GreetingService.GetGreeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return  greetingService.getGreeting(counter.incrementAndGet(), String.format(template, name));
    }
}
