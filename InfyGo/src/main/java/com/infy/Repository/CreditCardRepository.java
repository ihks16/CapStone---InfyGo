package com.infy.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infy.Entity.CreditCardDetails;

public interface CreditCardRepository extends JpaRepository<CreditCardDetails, String>{
	
}
