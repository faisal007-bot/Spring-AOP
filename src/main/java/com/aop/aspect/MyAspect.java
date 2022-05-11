package com.aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

// for AOP programming we have to add the aspectj runtime and aspectj weaver
// dependency or jar files in the classpath after that we have to enable the
// aop:autoproxy inside the configuration file

@Aspect
public class MyAspect {
	
//	in expression execution is used to tell that it will be executed
//	1st * represents all access modifiers and return types
//	we can also use access modifier and return type on the place of 1st *
//	after that we have to provide the package name then after that
//	we can use the name of the method on which this advice will be applied
//	we can also use the * on the place of the method in order to apply
//	the advice on all the methods of the provided class
//	at last we can use the empty () if the target method doesnt take any
//	parameters, if it takes parameters then we need to use the (..) ellipses
//	inside the () parentheses
	
	
//	before advice will be executed before the target method
	@Before("(execution(* com.aop.service.FakePaymentService.makePayment()))")
	public void beforePayment() {
		System.out.println("beginning the payment processing");
	}
	
//	after advice will be executed after the target method
	@After("(execution(* com.aop.service.FakePaymentService.makePayment()))")
	public void afterPayment() {
		System.out.println("payment done......");
	}
	
//	around advice is used to perform the task before the execution
//	of the target method as well after the target method
//	we have to use the object of the proceeding join point to separate the 
//	code that will be executed before and after the execution of the target method
//	proceed method of the proceeding joipoint is used to separate the before and
//	after code which will be executed before and after the target method
	@Around("(execution(* com.aop.service.FakePaymentService.*()))")
	public void aroundPayment(ProceedingJoinPoint point) {
		System.out.println("payment going to start.........");
		try {
			point.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		System.out.println("payment has been finished");
	}
	
//	afterreturning advice will be executed after returning the result from the
//	targeted method
	@AfterReturning("(execution(int com.aop.service.FakePaymentService.*(..)))")
	public void afterReturningAmount() {
		System.out.println("amount deposited successfully");
	}
	
//	after throwing adivce will be executed only when the targeted method will throw
//	an exception
//	the code of the advice will be executed before throwing the exception
//	we can use the throwing attribute inside the afterthrowing and the name of 
//	the variable in throwing must be same that used in the parameter of the 
//	advice method
	@AfterThrowing(throwing = "error",
			value = "(execution(* com.aop.service.FakePaymentService.validate(..)))")
	public void afterThrowing(/*Throwable error*/) {
		System.out.println("sorry the age of the user is invalid\nplease try again");
//		System.out.println(error.getMessage());
	}
}
