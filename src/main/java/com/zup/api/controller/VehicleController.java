package com.zup.api.controller;

import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zup.api.dto.VehicleDto;
import com.zup.api.form.VehicleForm;
import com.zup.api.model.User;
import com.zup.api.model.Vehicle;
import com.zup.api.repository.UserRepository;
import com.zup.api.repository.VehicleRepository;

@RestController
@RequestMapping("/vehicle")
public class VehicleController {
	@Autowired
	private VehicleRepository vehicleRepository;
	@Autowired
	private UserRepository userRepository;
	
	@PostMapping("/{id}")
	@Transactional
	public ResponseEntity<?> newVehicle(@RequestBody @Valid VehicleForm form, @PathVariable("id") long id) {
		try {
			User user = userRepository.getById(id);
			Vehicle vehicle = form.convert(user);
			vehicleRepository.save(vehicle);
			
			return ResponseEntity.status(HttpStatus.CREATED).body("Veiculo registrado com sucesso!");
			
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Ocorreu um erro: " + e.getMessage());
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> newVehicle(@PathVariable("id") long id) {
		try {
			User user = userRepository.getById(id);
			
			if(user.getCpf() == null)
				throw new Exception();
			
			List<Vehicle> vehicle = vehicleRepository.findAllByUser(user);			
			VehicleDto vehicleDto = new VehicleDto();			
			
			if(vehicle.isEmpty())
				return ResponseEntity.status(HttpStatus.PARTIAL_CONTENT).body("Esse usuário não possui veículos cadastrados!");
			
			return ResponseEntity.status(HttpStatus.OK).body(vehicleDto.convert(vehicle));
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Ocorreu um erro durante a listagem dos veículos!");
		}
	}
}
