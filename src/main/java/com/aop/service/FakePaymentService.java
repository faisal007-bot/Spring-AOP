package com.aop.service;

public class FakePaymentService {
	public void makePayment() {
		System.out.println("processing the payment");
	}
	
	public int deposit(int totalAmount,int amount) {
		totalAmount += amount;
		return totalAmount;
	}
	
	public void validate(int age) {
		if(age<18)
			throw new ArithmeticException("sorry the age of the user is less than 18");
		System.out.println("age of the user is valid = "+age);
	}
}
