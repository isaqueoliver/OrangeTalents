package com.zup.api.form;

import java.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.zup.api.model.User;

public class UserForm {
	@NotNull
	@NotEmpty
	private String name;
	
	@NotNull
	@NotEmpty
	private String email;
	
	@NotNull
	@NotEmpty
	@Size(min = 11, max = 11)
	private String cpf;
	
	@NotNull
	@NotEmpty
    @JsonFormat(pattern = "dd/MM/yyyy")
    @DateTimeFormat(iso = ISO.DATE)
    private LocalDate birthDate;
	
	public User convert() {
		User user = new User(this.name, this.email, this.cpf, this.birthDate);
		
		return user;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}
	
}
