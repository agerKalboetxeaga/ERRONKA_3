package com.example.restservice;

import java.util.Date;

import lombok.Data;

/**
 * This class is the model for Partidak.
 * 
 * @author kalboetxeaga.ager
 *
 */
@Data
public class Partida {
	private String puntuazioa;
	private String kills;
	private String time;
	private String date;
	private Employee employee;
	
	public Partida() {
		
	}
	public String getPuntuazioa() {
		return puntuazioa;
	}
	public void setPuntuazioa(String puntuazioa) {
		this.puntuazioa = puntuazioa;
	}
	public String getKills() {
		return kills;
	}
	public void setKills(String kills) {
		this.kills = kills;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
}