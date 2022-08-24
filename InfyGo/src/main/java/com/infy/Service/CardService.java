package com.infy.Service;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.infy.DTO.CreditcardDetailsDTO;
import com.infy.Entity.CreditCardDetails;
import com.infy.Repository.CreditCardRepository;

@Service
public class CardService {
		
	@Autowired 
	private CreditCardRepository creditcardDetailRepository;
	
	@Autowired
	private ModelMapper modelMapper;

	public ResponseEntity<String> makePayment(CreditcardDetailsDTO creditcardDetailsDTO){
		creditcardDetailRepository.saveAndFlush(this.modelMapper.map(creditcardDetailsDTO, CreditCardDetails.class));	
		
		return new ResponseEntity<String>("Valid Creadit Card", HttpStatus.ACCEPTED);
		
	}

}
