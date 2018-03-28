package com.home.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
	
	// realated advices for loggin
	
	// @Before advice
	//match on any calls to addAcount method in any class
	@Before("execution(public void com.home.aopdemo.dao.AccountDAO.addAccount())")
	public void beforeAddAccountAdvice(){
		System.out.println("========>Excuting before advice method ");
	}
	
	
	@Before("execution(public void add*())")
	public void beforeAddMethod(){
		System.out.println("*********>Excuting before any add method");
	}

	
	// match any return type the modifier public or public could be optional
	@Before("execution(* add*())")
	public void beforeAnyReturnMethod(){
		System.out.println("++++++++>Excuting before any add method");
	}
}
