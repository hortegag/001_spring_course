package com.home.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
	

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
	
	// Allways have to use the fully qualified name of the parameter
	// point cut expression match any method with a parameter account
	@Before("execution(* add*(com.home.aopdemo.Account))")
	public void beforeAnyMethodWithParameterAccout(){
		System.out.println("///////////>Excuting before any add method");
	}
	
	
	// point cut expression match any method with a parameter account
	@Before("execution(* add*(com.home.aopdemo.Account,..))")
	public void beforeAnyMethodWithTwoParameters(){
		System.out.println("||||||||||>Excuting before any add method");
	}	
	
	// point cut expression match any method with any parameters
	@Before("execution(* add*(..))")
	public void beforeAnyMethodWithAnyParameters(){
		System.out.println("_____________>Excuting before any add method");
	}	
	
	// point cut expression match any class and any method with any parameters
	@Before("execution(* com.home.aopdemo.dao.*.*(..))")
	public void beforeMatchPackage(){
		System.out.println(">>>>>>>>>>>>>>Excuting before any add method");
	}	
	
	
}
