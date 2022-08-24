package com.infy.DTO;

import javax.persistence.Column;
import javax.validation.constraints.Future;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

public class CreditcardDetailsDTO {

	@Size(max =  16, min = 16)
	@Pattern(regexp = "^[a-zA-Z0-9]*$",message = "enter valid credic card details")
	private String cardNumber;
	@NotNull
	private String apin;
	@NotNull
	private String cardHolderName;
	@NotNull
	@Size(min  = 3,max = 3)
	@Pattern(regexp = "^[0-9]*$")
	private String cvv;
	@NotNull
	@Pattern(regexp = "^[a-zA-Z]*$")
	private String expiryMonth;
	@NotNull
//	@Future
//	@DateTimeFormat(pattern = "yyyy")
	private String expiryYear;
	@NotNull
	private String totalBill;
	public CreditcardDetailsDTO(String cardNumber, String apin, String cardHolderName, String cvv, String expiryMonth,
			String expiryYear, String totalBill) {
		super();
		this.cardNumber = cardNumber;
		this.apin = apin;
		this.cardHolderName = cardHolderName;
		this.cvv = cvv;
		this.expiryMonth = expiryMonth;
		this.expiryYear = expiryYear;
		this.totalBill = totalBill;
	}
	public CreditcardDetailsDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public String getApin() {
		return apin;
	}
	public void setApin(String apin) {
		this.apin = apin;
	}
	public String getCardHolderName() {
		return cardHolderName;
	}
	public void setCardHolderName(String cardHolderName) {
		this.cardHolderName = cardHolderName;
	}
	public String getCvv() {
		return cvv;
	}
	public void setCvv(String cvv) {
		this.cvv = cvv;
	}
	public String getExpiryMonth() {
		return expiryMonth;
	}
	public void setExpiryMonth(String expiryMonth) {
		this.expiryMonth = expiryMonth;
	}
	public String getExpiryYear() {
		return expiryYear;
	}
	public void setExpiryYear(String expiryYear) {
		this.expiryYear = expiryYear;
	}
	public String getTotalBill() {
		return totalBill;
	}
	public void setTotalBill(String totalBill) {
		this.totalBill = totalBill;
	}
	@Override
	public String toString() {
		return "CreditcardDetailsDto [cardNumber=" + cardNumber + ", apin=" + apin + ", cardHolderName="
				+ cardHolderName + ", cvv=" + cvv + ", expiryMonth=" + expiryMonth + ", expiryYear=" + expiryYear
				+ ", totalBill=" + totalBill + "]";
	}

	
	
}
