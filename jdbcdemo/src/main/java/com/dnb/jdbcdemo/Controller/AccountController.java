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
import com.dnb.jdbcdemo.exceptions.IdNotFoundException;
import com.dnb.jdbcdemo.exceptions.InvalidContactNumber;
import com.dnb.jdbcdemo.payload.request.AccountRequest;
import com.dnb.jdbcdemo.service.AccountService;
import com.dnb.jdbcdemo.utils.RequestToEntityMapper;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/account")

public class AccountController {
	@Autowired
	RequestToEntityMapper mapper;
	@Autowired
	AccountService accountService;
	
	@DeleteMapping("/{accountId}")
	 public ResponseEntity<?> deleteaccount (@PathVariable("accountId") String accountId) throws IdNotFoundException, InvalidNameException, InvalidContactNumber{
		if(accountService.deleteaccount(accountId))
		
		{
			return ResponseEntity.noContent().build();
		}
			else
			{
				throw new IdNotFoundException("id not found");
				
			}
		}
	
	
	@GetMapping("/{accountId}") //it should help us to get the specific acoount details
	 public ResponseEntity<?> getAccountById (@PathVariable("accountId") String accountId) throws IdNotFoundException, InvalidNameException, InvalidContactNumber{
	 Optional<Account> optional = accountService.getAccountById(accountId);
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
			return responseEntity.notFound().build();
		}
	}
	
	@GetMapping("cn/{contactNumber}")
	public ResponseEntity<?> getAccountByContactNumber (@PathVariable("contactNumber") String contactNumber) throws IdNotFoundException, InvalidNameException, InvalidContactNumber{
		 Optional<Account> optional = accountService.getAccountByContactNumber(contactNumber);
			if(optional.isPresent())
		{
			return ResponseEntity.ok(optional.get());
		}
			else
			{
//				Map<String,String> map = new HashMap<>();
//				map.put("message","id not found");
//				map.put("HttpStatus", HttpStatus.NOT_FOUND+"");
//				ResponseEntity<?> responseEntity = new ResponseEntity(map,HttpStatus.NOT_FOUND);
//	 			//throw new IdNotFoundException("account id is not available");
				throw new InvalidContactNumber("contactNuber not found");
			}
		}
	
	@GetMapping("acn/{contactNumber}")
	public ResponseEntity<?>  getAllAccountsByContactNumber (@PathVariable("contactNumber") String contactNumber) throws IdNotFoundException, InvalidNameException, InvalidContactNumber{
		 List<Account> list1 = new ArrayList<Account>();
		 list1 = accountService.getAllAccountsByContactNumber(contactNumber);
		return ResponseEntity.ok(list1);

	}
	
	
	
	
	@PostMapping( "/create") 
	public ResponseEntity<?> createAccount (@Valid @RequestBody AccountRequest account){
	Account account2=mapper.getAccountEntityObject(account);
	
		
	   try {
		   Account account3 =accountService.createAccount(account2);
			
			return new ResponseEntity(account3,HttpStatus.CREATED);
		} catch (IdNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResponseEntity.badRequest().body(e.getMessage());
		}
		//return ResponseEntity.ok(mapper.getAccountEntityObject(account));
		
		
	}
}
