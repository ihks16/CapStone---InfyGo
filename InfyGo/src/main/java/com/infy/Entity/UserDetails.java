package com.infy.Entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class UserDetails {

	@Id
	private String userId;
	private String city;
	private String email;
	private String name;
	private String password;
	private String phone;
	
	@OneToMany(mappedBy = "userId",cascade = CascadeType.ALL)
	private List<TicketDetails> ticketDetails;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public List<TicketDetails> getTicketDetails() {
		return ticketDetails;
	}

	public void setTicketDetails(List<TicketDetails> ticketDetails) {
		this.ticketDetails = ticketDetails;
	}
}
