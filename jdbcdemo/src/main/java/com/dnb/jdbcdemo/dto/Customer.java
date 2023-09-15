package com.dnb.jdbcdemo.dto;

import java.util.regex.Pattern;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
@Data

@ToString
@NoArgsConstructor
@Entity
public class Customer {
	@Id
	private String customerID;
	private String customerName;
	private String customerContactNumber;
	private String customerAddress;
	private String customerPAN;
	//private String customerUUID;
//	public Customer(String customerID,String customerName,String customerContactNumber,String customerAddress,String customerPAN,String customerUUID) {
//		this.customerID=customerID;
//		this.customerName=customerName;
//		this.customerContactNumber=customerContactNumber;
//		this.customerAddress=customerAddress;
//		this.customerPAN=customerPAN;
//		//this.customerUUID=customerUUID;
//	}
//	public void setCustomerID(String customerID) {
//		this.customerID = customerID;
//	}
//	public void setCustomerName(String customerName) {
//		this.customerName = customerName;
//	}
//	public void setCustomerContactNumber(String customerContactNumber) {
//		this.customerContactNumber = customerContactNumber;
//	}
//	public void setCustomerAddress(String customerAddress) {
//		this.customerAddress = customerAddress;
//	}
//	public void setCustomerPAN(String customerPAN){
//		
//			this.customerPAN = customerPAN;
//		
//	}
////	public void setCustomerUUID(String customerUUID) {
////		this.customerUUID = customerUUID;
////	}
//	
	

}
