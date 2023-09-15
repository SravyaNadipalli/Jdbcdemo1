package com.dnb.jdbcdemo.service;

import java.util.List;
import java.util.Optional;

import javax.naming.InvalidNameException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.dnb.jdbcdemo.dto.Account;
import com.dnb.jdbcdemo.dto.Customer;
import com.dnb.jdbcdemo.exceptions.IdNotFoundException;
import com.dnb.jdbcdemo.exceptions.InvalidContactNumber;
import com.dnb.jdbcdemo.repo.AccountRepository;
import com.dnb.jdbcdemo.repo.CustomerRepository;

@Service
public class AccountServiceImpl implements AccountService {
@Autowired
private AccountRepository accountRepository;
	

	@Override
	public Account createAccount(Account account) throws IdNotFoundException {
		return accountRepository.save(account);
	}
	@Override
	public Optional<Account> getAccountById(String accountId) throws InvalidNameException, InvalidContactNumber {
		// TODO Auto-generated method stub
		return accountRepository.findById(accountId);
	}
	@Override
	public boolean deleteaccount(String accountId) throws IdNotFoundException {
		// TODO Auto-generated method stub
		if(accountRepository.existsById(accountId)==true) {
			 accountRepository.deleteById(accountId);
			 return true;
		}
		else
			return false;
		
	}
	@Override
	public Iterable<Account> getAllAcccounts() {
		// TODO Auto-generated method stub
		return accountRepository.findAll();
	}
	@Override
	public Optional<Account> getAccountByContactNumber(String ContactNumber) {
		// TODO Auto-generated method stub
		return accountRepository.findByContactNumber(ContactNumber);
	}
	@Override
	public List<Account> getAllAccountsByContactNumber(String ContactNumber) {
		// TODO Auto-generated method stub
		return accountRepository.findAllAccountsByContactNumber(ContactNumber);
	}
	

//	@Override
//	public Account createAccount(Account account) throws IdNotFoundException{
//		Optional<Customer> optional = customerRepository.getCustomertById(account.getCustomer().getCustomerID());
//		if (optional.isPresent())
//			return accountRepo2Impl.createAccount(account);
//		else {
//			throw new IdNotFoundException("customerid not Found");
//		}
//		
//	}
//
//	@Override
//	public Optional<Account> getAccountById(String accountId) throws InvalidNameException, InvalidContactNumber {
//
//		return accountRepo2Impl.getAccountById(accountId);
//	}
//
//	@Override
//	public Account deleteaccount(Account account) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public List<Account> getAllAcccounts() {
//		// TODO Auto-generated method stub
//		return null;
//	}

}