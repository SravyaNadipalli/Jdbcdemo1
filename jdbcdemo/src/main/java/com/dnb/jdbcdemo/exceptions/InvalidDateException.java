package com.dnb.jdbcdemo.exceptions;

public class InvalidDateException extends Exception {

	public InvalidDateException(String msg) {
		// TODO Auto-generated constructor stub
		super(msg);
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString()+super.getMessage();
	}
}
