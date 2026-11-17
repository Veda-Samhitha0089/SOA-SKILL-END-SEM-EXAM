package com.example.tourist.entity;


public class Tourist {
	private String name;
	private String email;
	private String destination;

	public Tourist(String name, String email, String destination) {
	    this.name = name;
	    this.email = email;
	    this.destination = destination;
	}

	public String getName() {
	    return name;
	}

	public String getEmail() {
	    return email;
	}

	public String getDestination() {
	    return destination;
	}
}
