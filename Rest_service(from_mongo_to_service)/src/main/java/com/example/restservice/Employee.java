package com.example.restservice;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class Employee {
	private String id;
	private String name;
	private String jobTitle;
	private String workPhone;
	private String workEmail;
	
	public Employee() {
		
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStreet() {
		return jobTitle;
	}
	public void setStreet(String street) {
		this.jobTitle = street;
	}
	public String getZip() {
		return workPhone;
	}
	public void setZip(String zip) {
		this.workPhone = zip;
	}
	public String getCity() {
		return workEmail;
	}
	public void setCity(String city) {
		this.workEmail = city;
	}
	
}
