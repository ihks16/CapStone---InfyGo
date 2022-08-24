package com.infy.Entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class PassengerDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int passengerId;
	private String passsengerAge;
	private String passengerGender;
	private String PassengerName;
	
	@ManyToOne(targetEntity = TicketDetails.class,cascade = CascadeType.ALL)
	@JoinColumn(name = "ticket_pnr")
	private TicketDetails ticketpnr;

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

	public TicketDetails getTicketpnr() {
		return ticketpnr;
	}

	public void setTicketpnr(TicketDetails ticketpnr) {
		this.ticketpnr = ticketpnr;
	}
	
	
}
