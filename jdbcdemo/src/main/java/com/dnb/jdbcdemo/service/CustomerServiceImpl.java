package com.dnb.jdbcdemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dnb.jdbcdemo.dto.Customer;
import com.dnb.jdbcdemo.exceptions.IdNotFoundException;
import com.dnb.jdbcdemo.repo.CustomerRepository;
@Service
public class CustomerServiceImpl implements CustomerService{
	@Autowired
	CustomerRepository customerRepository;

	@Override
	public Customer createCustomer(Customer customer) throws IdNotFoundException {
		// TODO Auto-generated method stub
		return customerRepository.save(customer);
	}

	@Override
	public Optional<Customer> getCustomertById(String customerID) {
		// TODO Auto-generated method stub
		return customerRepository.findById(customerID);
	}

	@Override
	public boolean deleteCustomerByID(String customerID) throws IdNotFoundException {
		// TODO Auto-generated method stub
		if(customerRepository.existsById(customerID)==true) {
			customerRepository.deleteById(customerID);
			 return true;
		}
		else
			return false;
	}

	@Override
	public Iterable<Customer> getAllCustomers() {
		// TODO Auto-generated method stub
		return customerRepository.findAll();
	}

	@Override
	public Optional< Customer> getCustomerByCustomerContactNumber(String customerContactNumber) {
		// TODO Auto-generated method stub
		return customerRepository.findByCustomerContactNumber(customerContactNumber);
	}


}
