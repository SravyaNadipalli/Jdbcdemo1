package com.dnb.jdbcdemo.service;

import java.util.List;
import java.util.Optional;

import com.dnb.jdbcdemo.dto.Customer;
import com.dnb.jdbcdemo.exceptions.IdNotFoundException;
import com.dnb.jdbcdemo.exceptions.InvalidContactNumber;

public interface CustomerService {
	public Customer createCustomer(Customer customer)throws IdNotFoundException;
	public Optional<Customer> getCustomertById(String customerID);
	public boolean deleteCustomerByID(String customerID) throws IdNotFoundException;
	public Iterable<Customer> getAllCustomers();
	public Optional<Customer> getCustomerByCustomerContactNumber(String customerContactNumber)throws InvalidContactNumber;

}
