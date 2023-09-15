package com.dnb.jdbcdemo.Controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.naming.InvalidNameException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dnb.jdbcdemo.dto.Account;
import com.dnb.jdbcdemo.dto.Customer;
import com.dnb.jdbcdemo.exceptions.IdNotFoundException;
import com.dnb.jdbcdemo.exceptions.InvalidContactNumber;
import com.dnb.jdbcdemo.service.AccountService;
import com.dnb.jdbcdemo.service.CustomerService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/customer")

public class CustomerController {
	@Autowired
	CustomerService customerService;
	
	@DeleteMapping("/{customerID}")
	 public ResponseEntity<?> deletecustomerByID (@PathVariable("customerID") String customerID) throws IdNotFoundException, InvalidNameException, InvalidContactNumber{
		if(customerService.deleteCustomerByID(customerID))
		
		{
			return ResponseEntity.noContent().build();
		}
			else
			{
				throw new IdNotFoundException("id not found");
				
			}
		}

 /* @GetMapping("/{accountId}") //it should help us to get the specific acoount details
	 public ResponseEntity<?> getAccountById (@PathVariable("customerId") String customerId) throws IdNotFoundException, InvalidNameException, InvalidContactNumber{
	 Optional<Customer> optional = customerService.getCustomertById(customerId);
		if(optional.isPresent())
	{
		return ResponseEntity.ok(optional.get());
	}
		else		{
			Map<String,String> map = new HashMap<>();
			map.put("message","id not found");
			map.put("HttpStatus", HttpStatus.NOT_FOUND+"");
			ResponseEntity<?> responseEntity = new ResponseEntity(map,HttpStatus.NOT_FOUND);
 			//throw new IdNotFoundException("account id is not available");
			return responseEntity.notFound().build();
		}
	}*/
	
	@GetMapping("/cn/{customerContactNumber}")
	public ResponseEntity<?> getCustomerByCustomerContactNumber (@PathVariable("customerContactNumber") String customerContactNumber) throws IdNotFoundException, InvalidNameException, InvalidContactNumber{
		 Optional<Customer> optional = customerService.getCustomerByCustomerContactNumber(customerContactNumber);
		 if(optional.isPresent())
		{
			return ResponseEntity.ok(optional.get());
		}
			else
			{
				Map<String,String> map = new HashMap<>();
				map.put("message","id not found");
				map.put("HttpStatus", HttpStatus.NOT_FOUND+"");
				ResponseEntity<?> responseEntity = new ResponseEntity(map,HttpStatus.NOT_FOUND);
	 			//throw new IdNotFoundException("account id is not available");
				throw new InvalidContactNumber("contactNuber not found");
			}}
//		}
//	
//	@GetMapping("acn/{contactNumber}")
//	public ResponseEntity<?>  getAllAccountsByContactNumber (@PathVariable("contactNumber") String contactNumber) throws IdNotFoundException, InvalidNameException, InvalidContactNumber{
//		 List<Account> list1 = new ArrayList<Account>();
//		 list1 = accountService.getAllAccountsByContactNumber(contactNumber);
//		return ResponseEntity.ok(list1);
//
//	}
//	
//	
//	
	@PostMapping("/create")
	public ResponseEntity<?> createCustomer(@Valid @RequestBody Customer customer) {
		Customer customer2=null;
			try {
				customer2 = customerService.createCustomer(customer);
				return new ResponseEntity(customer2,HttpStatus.CREATED);
			} catch (IdNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return new ResponseEntity(customer2,HttpStatus.CREATED);
			//return ResponseEntity.badRequest().body(e.getMessage());
		
	}
}

//}
