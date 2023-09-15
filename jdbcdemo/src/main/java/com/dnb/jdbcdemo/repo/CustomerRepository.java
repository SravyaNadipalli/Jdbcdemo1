package com.dnb.jdbcdemo.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dnb.jdbcdemo.dto.Account;
import com.dnb.jdbcdemo.dto.Customer;
@Repository
public interface CustomerRepository extends CrudRepository<Customer, String> {

	//Optional<Customer> findByCustomerByCustomerContactNumber(String customerContactNumber);

	//Optional<Customer> findByCustomerContactNumber(String customerContactNumber);

	//Optional<Customer> findByCustomerContactNumber(String customerContactNumber);

	//Optional<Customer> findByCustomerContactNumber(String customerContactNumber);

	Optional<Customer> findByCustomerContactNumber(String customerContactNumber);

//	void deleteById(int customerID);
//
//	boolean existsById(int customerID);

	

}
