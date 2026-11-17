package com.example.tourist.controller;

import com.example.tourist.entity.Tourist;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api")
public class TouristController {

	@GetMapping("/tourists")
	public ResponseEntity<?> getAllTourists(
	        @RequestHeader(value = "Authorization", required = false)
	        String authHeader) {

	    // Check token presence
	    if (authHeader == null || !authHeader.startsWith("Bearer ")) {
	        return ResponseEntity.status(401)
	                .body("Token missing");
	    }

	    // Extract token
	    String token = authHeader.substring(7);

	    // Temporary token validation for testing
	    if (!token.equals("my-secret-token")) {
	        return ResponseEntity.status(401)
	                .body("Invalid token");
	    }

	    // Sample tourist records (no database)
	    List<Tourist> tourists = Arrays.asList(
	            new Tourist("Rahul", "rahul@gmail.com", "Goa"),
	            new Tourist("Priya", "priya@gmail.com", "Kerala"),
	            new Tourist("Arjun", "arjun@gmail.com", "Hyderabad")
	    );

	    return ResponseEntity.ok(tourists);
	}
}
