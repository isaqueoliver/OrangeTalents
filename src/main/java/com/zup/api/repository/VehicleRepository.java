package com.zup.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zup.api.model.User;
import com.zup.api.model.Vehicle;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

	List<Vehicle> findAllByUser(User user);
	
}