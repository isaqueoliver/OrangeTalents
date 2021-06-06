package com.zup.api.dto;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.zup.api.model.Vehicle;

public class VehicleDto {
	private String make;
	
	private String model;
	
	private int year;
	
	private String carRotation;
	
	private Boolean isRotationActive; 
	
	public VehicleDto() {}
	
	public VehicleDto(String make, String model, int year, String carRotation, Boolean isRotationActive) {
		super();
		this.make = make;
		this.model = model;
		this.year = year;
		this.carRotation = carRotation;
		this.isRotationActive = isRotationActive;
	}
	
	public VehicleDto(Vehicle vehicle) {
		this.make = vehicle.getMake();
		this.model = vehicle.getModel();
		this.year = vehicle.getYear();
		this.carRotation = vehicle.getCarRotation();
		this.isRotationActive = vehicle.getIsRotationActive();
	}
	
	public List<VehicleDto> convert(List<Vehicle> vehicles) {
		
		return vehicles.stream().map(VehicleDto::new).collect(Collectors.toList());
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
