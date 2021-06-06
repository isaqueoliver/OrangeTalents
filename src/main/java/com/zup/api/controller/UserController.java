package com.zup.api.controller;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zup.api.form.UserForm;
import com.zup.api.dto.UserDto;
import com.zup.api.model.User;
import com.zup.api.repository.UserRepository;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserRepository userRepository;
	
	@PostMapping
	@Transactional
	public ResponseEntity<?> newUser(@RequestBody @Valid UserForm form) {
		try {
			User user = form.convert();
			userRepository.save(user);
			
			UserDto userDto = new UserDto("Usuário registrado com sucesso!", user.getId());
			
			return ResponseEntity.status(HttpStatus.CREATED).body(userDto);
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Ocorreu um erro: " + e.getMessage());
		}
	}
}
