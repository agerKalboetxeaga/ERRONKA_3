package com.example.restservice;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class Employee {
	private String id;
	private String name;
	private String street;
	private String zip;
	private String city;
	private String email;
	private String mobile_phone;
}
