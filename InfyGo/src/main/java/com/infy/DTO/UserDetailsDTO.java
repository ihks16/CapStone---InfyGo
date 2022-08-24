package com.infy.DTO;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.context.annotation.PropertySources;

import com.infy.Entity.TicketDetails;


public class UserDetailsDTO {

	@NotNull
	@NotEmpty
	private String userId;
	@NotNull(message = "name can not be empty")
	@NotEmpty
	private String city;
	@Email(message = "{user.mail.invalid}")
	@NotNull
	private String email;
	@NotNull
	private String name;
	
	@NotNull(message = "{user.password.must}")
	@Size(min = 9)
	@Pattern(regexp = "^[a-zA-Z0-9]*$",message = "{user.password.invalid}")
	private String password;
	@Column(length = 10)
	private String phone;
	
	private List<TicketDetails> ticketDetails;

	public UserDetailsDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserDetailsDTO(String userId, String city, String email, String name, String password, String phone,
			List<TicketDetails> ticketDetails) {
		super();
		this.userId = userId;
		this.city = city;
		this.email = email;
		this.name = name;
		this.password = password;
		this.phone = phone;
		this.ticketDetails = ticketDetails;
	}

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

	@Override
	public String toString() {
		return "UserDetailsDto [userId=" + userId + ", city=" + city + ", email=" + email + ", name=" + name
				+ ", password=" + password + ", phone=" + phone + ", ticketDetails=" + ticketDetails + "]";
	}

	
}
