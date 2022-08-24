package com.infy.Service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.infy.DTO.*;
import com.infy.Entity.*;
import com.infy.Exception.*;
import com.infy.Repository.*;

@Service
public class TicketService {
	
	@Autowired
	private TicketRepository TicketRepository;
	
	@Autowired
	private FlightRepository flightRepository;

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PassengerRepository passengerRepository;
	
	@Autowired 
	private ModelMapper modelMapper;
	
	public TicketDetails bookTicket(String flightId,String userId,List<PassengerDetailsDTO> passengerDetailsDtos) throws FlightNotExist, UserNotExist, SeatNotAvailable {
		
		System.out.println("#######################################");
		System.out.println("flight id :"+flightId);
		System.out.println("user id :"+userId);
		Optional<FlightDetails> flight =  flightRepository.findById(flightId);
		Optional<UserDetails> user = userRepository.findById(userId);
		if(!user.isPresent()) {
			throw new UserNotExist("please enter valid user id ");
		}
		if(!flight.isPresent()) {
			throw new FlightNotExist("please enter valid flight id");
		}
		
		FlightDetails flightDetails = flight.get();
		UserDetails userDetails =user.get();
		int seatRequire= passengerDetailsDtos.size();

		if(flightDetails.getSeatCount()>=seatRequire) {
			TicketDetails ticketDetails = new TicketDetails();
				
				ticketDetails.setBookingDate(new java.util.Date());
				ticketDetails.setDeparturefDate(flightDetails.getFlightAvailableDate());
				ticketDetails.setDepartureTime(flightDetails.getDepartureTime());
				ticketDetails.setFlightId(flightDetails);
				ticketDetails.setNoOfSeats(seatRequire);
				ticketDetails.setTotalFare(((flightDetails.getFare())*seatRequire));
				ticketDetails.setUserId(userDetails);
				
//				ticketRepository.saveAndFlush(ticketDetails);
				
				for(int i=0;i<passengerDetailsDtos.size();i++) {
					
					PassengerDetails passengerDetails = new PassengerDetails();
					passengerDetails.setPassengerName(passengerDetailsDtos.get(i).getPassengerName());
					passengerDetails.setPassengerGender(passengerDetailsDtos.get(i).getPassengerGender());
					passengerDetails.setPasssengerAge(passengerDetailsDtos.get(i).getPasssengerAge());
					passengerDetails.setTicketpnr(ticketDetails);
					passengerRepository.saveAndFlush(passengerDetails);
					System.out.println("@@@@@@@@@@@@@@@@@@@@@@@");
				}
			
			flightDetails.setSeatCount(flightDetails.getSeatCount()-seatRequire);
			flightRepository.save(flightDetails);
//			TicketDetailsDto ticketDetailsDto = this.modelMapper.map(ticketDetails, TicketDetailsDto.class);
//			return new ResponseEntity<TicketDetailsDto>(this.modelMapper.map(ticketDetails, TicketDetailsDto.class),HttpStatus.ACCEPTED);
			return ticketDetails;	
			}else
			{
				throw  new SeatNotAvailable("number  of  seat availabale is less than requirment");
			}
	
	}
}
