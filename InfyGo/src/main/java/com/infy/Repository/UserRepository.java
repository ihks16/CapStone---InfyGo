package com.infy.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infy.Entity.UserDetails;

public interface UserRepository extends JpaRepository< UserDetails, String>{

	public Optional<UserDetails> findByNameAndPhone(String name,String phone);
	
}
