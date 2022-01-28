package com.example.restservice;

import lombok.Data;
/**
 * This class is the model for Employee.
 * 
 * @author kalboetxeaga.ager
 *
 */
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

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public String getWorkPhone() {
		return workPhone;
	}

	public void setWorkPhone(String workPhone) {
		this.workPhone = workPhone;
	}

	public String getWorkEmail() {
		return workEmail;
	}

	public void setWorkEmail(String workEmail) {
		this.workEmail = workEmail;
	}
	
	
}
