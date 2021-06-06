package com.zup.api.model;

import java.time.DayOfWeek;
import java.time.LocalDate;

import javax.persistence.*;

@Entity
public class Vehicle {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String make;
	
	private String model;
	
	private int year;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private User user;
	
	private String carRotation;
	
	private Boolean isRotationActive;

	public Vehicle() {}
	
	public Vehicle(String make, String model, int year, User user, String carRotation, Boolean isRotationActive) {
		super();
		this.make = make;
		this.model = model;
		this.year = year;
		this.user = user;
		this.carRotation = carRotation;
		this.isRotationActive = isRotationActive;
	}

	public Long getId() {
		return id;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getCarRotation() {
		return carRotation;
	}

	public void setCarRotation(String carRotation) {
		this.carRotation = carRotation;
	}

	public Boolean getIsRotationActive() {
		int day = Character.getNumericValue(Integer.toString(this.year).toCharArray()[Integer.toString(this.year).toCharArray().length-1]);
		DayOfWeek today = LocalDate.now().getDayOfWeek();
		
		switch(day) {
			case 0:
				this.isRotationActive = today == DayOfWeek.MONDAY ? true : false;
				break;
			case 1:
				this.isRotationActive = today == DayOfWeek.MONDAY ? true : false;
				break;
			case 2:
				this.isRotationActive = today == DayOfWeek.TUESDAY ? true : false;
				break;
			case 3:
				this.isRotationActive = today == DayOfWeek.TUESDAY ? true : false;
				break;
			case 4:
				this.isRotationActive = today == DayOfWeek.WEDNESDAY ? true : false;
				break;
			case 5:
				this.isRotationActive = today == DayOfWeek.WEDNESDAY ? true : false;
				break;
			case 6:
				this.isRotationActive = today == DayOfWeek.THURSDAY ? true : false;
				break;
			case 7:
				this.isRotationActive = today == DayOfWeek.THURSDAY ? true : false;
				break;
			case 8:
				this.isRotationActive = today == DayOfWeek.FRIDAY ? true : false;
				break;
			case 9:
				this.isRotationActive = today == DayOfWeek.FRIDAY ? true : false;
				break;
		}
		return isRotationActive;
	}

	public void setIsRotationActive(Boolean isRotationActive) {
		this.isRotationActive = isRotationActive;
	}
	
	
}
