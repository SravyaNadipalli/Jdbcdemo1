package com.dnb.jdbcdemo.service;

import java.util.List;
import java.util.Optional;

import javax.naming.InvalidNameException;

import com.dnb.jdbcdemo.dto.Account;
import com.dnb.jdbcdemo.exceptions.IdNotFoundException;
import com.dnb.jdbcdemo.exceptions.InvalidContactNumber;

public interface AccountService  {
	public Account createAccount(Account account) throws IdNotFoundException;
	public Optional<Account> getAccountById(String accountId) throws InvalidNameException, InvalidContactNumber;
	public boolean deleteaccount(String accountId) throws IdNotFoundException;
	public Iterable<Account> getAllAcccounts();
	public Optional<Account> getAccountByContactNumber(String contactNumber) throws InvalidContactNumber;
	//Optional<Account> getAccountBycontactNumber(String contactNumber);
    public List<Account> getAllAccountsByContactNumber(String contactNumber) throws InvalidContactNumber;

}
