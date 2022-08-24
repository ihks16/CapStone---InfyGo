package com.infy.DTO;

import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import com.infy.Entity.TicketDetails;

public class PassengerDetailsDTO{
	private int passengerId;
	@NotNull
	private String passsengerAge;
	@NotNull
	private String passengerGender;
	@NotNull
	private String PassengerName;
	private TicketDetailsDTO ticketpnr;
	public PassengerDetailsDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PassengerDetailsDTO(int passengerId, String passsengerAge, String passengerGender, String passengerName,
			TicketDetailsDTO ticketpnr) {
		super();
		this.passengerId = passengerId;
		this.passsengerAge = passsengerAge;
		this.passengerGender = passengerGender;
		PassengerName = passengerName;
		this.ticketpnr = ticketpnr;
	}
	public int getPassengerId() {
		return passengerId;
	}
	public void setPassengerId(int passengerId) {
		this.passengerId = passengerId;
	}
	public String getPasssengerAge() {
		return passsengerAge;
	}
	public void setPasssengerAge(String passsengerAge) {
		this.passsengerAge = passsengerAge;
	}
	public String getPassengerGender() {
		return passengerGender;
	}
	public void setPassengerGender(String passengerGender) {
		this.passengerGender = passengerGender;
	}
	public String getPassengerName() {
		return PassengerName;
	}
	public void setPassengerName(String passengerName) {
		PassengerName = passengerName;
	}
	public TicketDetailsDTO getTicketpnr() {
		return ticketpnr;
	}
	public void setTicketpnr(TicketDetailsDTO ticketpnr) {
		this.ticketpnr = ticketpnr;
	}
	@Override
	public String toString() {
		return "PassengerDetailsDto [passengerId=" + passengerId + ", passsengerAge=" + passsengerAge
				+ ", passengerGender=" + passengerGender + ", PassengerName=" + PassengerName + ", ticketpnr="
				+ ticketpnr + "]";
	}
	
	
}
