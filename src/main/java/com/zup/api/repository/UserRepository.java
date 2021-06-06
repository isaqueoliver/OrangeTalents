package com.zup.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zup.api.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
}
