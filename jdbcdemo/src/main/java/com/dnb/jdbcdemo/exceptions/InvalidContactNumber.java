package com.dnb.jdbcdemo.exceptions;

public class InvalidContactNumber extends Exception {

	public InvalidContactNumber(String msg) {
		// TODO Auto-generated constructor stub
		super(msg);
		
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString()+super.getMessage();
	}

}
