package com.dnb.jdbcdemo.dto;

import java.time.LocalDate;
import java.util.regex.Pattern;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.validator.constraints.Length;

import com.dnb.jdbcdemo.exceptions.InvalidContactNumber;
import com.dnb.jdbcdemo.exceptions.InvalidNameException;
import com.dnb.jdbcdemo.utils.CustomAccountIdGenerator;
import com.dnb.jdbcdemo.utils.DatePrefixGenerator;

import jakarta.annotation.Generated;
import jakarta.annotation.Nonnull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString(exclude = "customer")
@Entity
@Table
public class Account {
	@Id
	@NotBlank(message = "account id should not be blank")
//	@GeneratedValue(strategy = GenerationType.UUID)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "account_seq")
	@GenericGenerator(name = "account_seq", strategy = "com.dnb.jdbcdemo.utils.DatePrefixGenerator", parameters = {
			@Parameter(name = DatePrefixGenerator.INCREMENT_PARAM, value = "50"),
			//@Parameter(name = CustomAccountIdGenerator.VALUE_PREFIX_PARAMETER, value = "A_"),
			@Parameter(name = DatePrefixGenerator.NUMBER_FORMAT_PARAMETER, value = "%05d") })
	private String accountId;
	@Column(nullable = false)
	@NotBlank(message = "account Holdername should not be blank")
	private String accountHolderName;

	private String accountType;
	@Min(value = 0, message="value should not be negative")
	private float balance;
	@Length(min = 10, max=10, message= "Contact Number should be 10 digits")
	@jakarta.validation.constraints.Pattern(regexp ="^[0-9]{10}$",message ="it must have 10 digits" )
	private String contactNumber;
	@NotNull(message ="Date must be provided")
	private String address;
	private LocalDate accountCreateDate = LocalDate.now();
	//@jakarta.validation.constraints.Pattern(regexp="^\\d{4}-\\d{2}-\\d{2}$", message="Chevk the date")
	@NotNull(message = "date must be provided")
	private LocalDate dob;
	@Transient

	private Boolean AccountStatus;
	// private Customer customer;
	private int customerId;

	public Account(String accountId, String accountHolderName, String accountType, float balance, String contactNumber,
			String address, LocalDate accountCreateDate, LocalDate dob, boolean accountStatus, Customer customer)
			throws InvalidNameException, InvalidContactNumber {

		super();
	/*this.setAccountId(accountId);
	this.setAccountHolderName(accountHolderName);
	this.setAccountType(accountType);
	this.setBalance(balance);
	this.setContactNumber(contactNumber);
	this.setAddress(address);
//	this.setAccountCreatedDate(accountCreatedDate);
//	this.setAccountStatus(accountStatus);
//	this.setDob(dob);
     this.setCustomer(customer);*/
	}

	
}
