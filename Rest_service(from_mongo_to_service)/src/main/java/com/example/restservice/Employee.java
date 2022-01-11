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
	private String phone;
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
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile_phone() {
		return phone;
	}
	public void setMobile_phone(String mobile_phone) {
		this.phone = mobile_phone;
	}
}
