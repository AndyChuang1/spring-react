package com.example.rest_service.service;

import org.springframework.stereotype.Service;

@Service
public class GreetingService {
    // Defining a record inside the class
    public record GetGreeting(Long id, String data) {
    }

    // A method that returns an instance of the GetGreeting record
    public GetGreeting getGreeting(Long id, String content) {
        // Return a new record with the provided id and a sample data
        return new GetGreeting(id, content);
    }
}
