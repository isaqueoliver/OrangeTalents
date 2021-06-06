package com.zup.api.form;

import java.time.DayOfWeek;
import java.time.LocalDate;

import javax.persistence.Convert;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.zup.api.model.User;
import com.zup.api.model.Vehicle;

public class VehicleForm {
	@NotNull
	@NotEmpty
	private String make;
	
	@NotNull
	@NotEmpty
	private String model;
	
	@NotNull
	@NotEmpty
	private int year;
	
	private String carRotation;
	
	private Boolean isRotationActive;
	
	public Vehicle convert(User user) {
		int day = Character.getNumericValue(Integer.toString(this.year).toCharArray()[Integer.toString(this.year).toCharArray().length-1]);
		DayOfWeek today = LocalDate.now().getDayOfWeek();
		
		switch(day) {
			case 0:
				this.carRotation = "segunda-feira";
				this.isRotationActive = today == DayOfWeek.MONDAY ? true : false;
				break;
			case 1:
				this.carRotation = "segunda-feira";
				this.isRotationActive = today == DayOfWeek.MONDAY ? true : false;
				break;
			case 2:
				this.carRotation = "terca-feira";
				this.isRotationActive = today == DayOfWeek.TUESDAY ? true : false;
				break;
			case 3:
				this.carRotation = "terca-feira";
				this.isRotationActive = today == DayOfWeek.TUESDAY ? true : false;
				break;
			case 4:
				this.carRotation = "quarta-feira";
				this.isRotationActive = today == DayOfWeek.WEDNESDAY ? true : false;
				break;
			case 5:
				this.carRotation = "quarta-feira";
				this.isRotationActive = today == DayOfWeek.WEDNESDAY ? true : false;
				break;
			case 6:
				this.carRotation = "quinta-feira";
				this.isRotationActive = today == DayOfWeek.THURSDAY ? true : false;
				break;
			case 7:
				this.carRotation = "quinta-feira";
				this.isRotationActive = today == DayOfWeek.THURSDAY ? true : false;
				break;
			case 8:
				this.carRotation = "sexta-feira";
				this.isRotationActive = today == DayOfWeek.FRIDAY ? true : false;
				break;
			case 9:
				this.carRotation = "sexta-feira";
				this.isRotationActive = today == DayOfWeek.FRIDAY ? true : false;
				break;
		}
		
		
		Vehicle vehicle = new Vehicle(this.make, this.model, this.year, user, this.carRotation, this.isRotationActive);
		
		return vehicle;
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
