package com.dnb.jdbcdemo;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import javax.naming.InvalidNameException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.dnb.jdbcdemo.dto.Account;
import com.dnb.jdbcdemo.dto.Customer;
import com.dnb.jdbcdemo.exceptions.IdNotFoundException;
import com.dnb.jdbcdemo.exceptions.InvalidContactNumber;
import com.dnb.jdbcdemo.service.AccountService;
import com.dnb.jdbcdemo.service.CustomerService;

@SpringBootApplication
public class JdbcdemoApplication {

	public static void main(String[] args) throws IdNotFoundException {
//		ApplicationContext applicationContext = 
		SpringApplication.run(JdbcdemoApplication.class, args);
//		AccountService accountService = applicationContext.getBean(AccountService.class);
//		CustomerService customerService= applicationContext.getBean(CustomerService.class);
////		Customer customer = null;
//        Account account = new Account();
//        account.setContactNumber("12345");
//     accountService.createAccount(account);
//	try {
//      		Account account= new Account("0", "poo","Saving",103,"1234557892","sbc",LocalDate.now(),LocalDate.of(2002, 12, 20),true,new Customer(1, "pooja", "hh", "Hyderab", "FXAAS12345", "FSVWR12123"));
//		} catch (Exception e) {
//		// TODO Auto-generated catch block			e.printStackTrace();
//		}
////		try {
////			customer= new Customer(1, "pooja", "hh", "Hyderab", "FXAAS12345", "FSVWR12123");
////		}catch (Exception e) {
////			// TODO Auto-generated catch block
////			e.printStackTrace();
////		}
////		Scanner sc = new Scanner(System.in);
////		while (true) {
////			System.out.println(
////					"1.Create Customer Account\n2.Get Customer Details by ID\n3. Delete Customer Details by ID\n4.Retrieve All Records\n5.Exit");
////			System.out.println();
////			System.out.print("Enter your Choice: ");
////			int value = sc.nextInt();
////			switch (value) {
////			case 1:
////				try {
////					Account account2 = accountService.createAccount(account);
////					System.out.println(account2.toString());
//////					Customer customer2 = customerService.createCustomer(customer);
//////					System.out.println(customer2);
////				} catch (Exception e) {
////					// TODO Auto-generated catch block
////					e.printStackTrace();
////				} 
////				break;
////			case 2:
////				System.out.println("Enter the account id:");
////				String accountNumber = sc.next();
////				Optional<Account> returnAccount;
////				try {
////					returnAccount = accountService.getAccountById(accountNumber);
////					System.out.println(returnAccount);
////				} catch (InvalidNameException e) {
////					// TODO Auto-generated catch block
////					e.printStackTrace();
////				} catch (InvalidContactNumber e) {
////					// TODO Auto-generated catch block
////					e.printStackTrace();
////				}
////				break;
////
////			case 3:
////				System.out.println("Enter the account id:");
////				String accountID = sc.next();
////				
////				try {
////					System.out.println(accountService.deleteaccount(accountID));
////				} catch (IdNotFoundException e) {
////					// TODO Auto-generated catch block
////					e.printStackTrace();
////				}
////				break;
////
////			case 4:
////				applicationContext.getBean(AccountService.class).getAllAcccounts().forEach(e->System.out.println(e));
////				break;
////
////			case 5:
////				System.exit(0);
////			default:
////				System.out.println("Please choose a proper option");
////			}
////		}
//
	}

}
