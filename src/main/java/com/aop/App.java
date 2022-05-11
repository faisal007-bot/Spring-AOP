package com.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.aop.service.FakePaymentService;

public class App {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		ApplicationContext context = 
				new ClassPathXmlApplicationContext("com/aop/config.xml");
		FakePaymentService service = 
				context.getBean("service",FakePaymentService.class);
		
//		service.makePayment();
//		int deposit = service.deposit(10000, 473);
//		System.out.println(deposit);
		service.validate(12);
	}
}
