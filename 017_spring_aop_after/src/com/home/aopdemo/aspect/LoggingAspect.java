package com.home.aopdemo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.home.aopdemo.Account;

@Aspect
@Component
@Order(15)
public class LoggingAspect {
	
	
	@After("execution(* com.home.aopdemo.dao.AccountDAO.findAccounts(..))")
	public void afterFinally(JoinPoint joinPoint){
		
		
		String method = joinPoint.getSignature().toShortString();
		System.out.println("<<<<<<<<<<<<< @After Execute after method "+method);

	
		
	}

	// point cut expression match any class and any method with any parameters
	// combingin point cut declarations
	@Before("com.home.aopdemo.aspect.AOPAspectExpression.forDaoPackage()")
	public void beforeMatchPackage(){
		System.out.println(">>>>>>>>>>>>>>Excuting before any add method");
	}	
	

	@AfterReturning(
			pointcut="execution(* com.home.aopdemo.dao.AccountDAO.findAccounts(..))",
			returning="result")
	public void afterReturnFindAccounts(
			JoinPoint joinPoint, List<Account> result){
		
		String method = joinPoint.getSignature().toShortString();
		System.out.println("++++++++++++>Execute after @AfterReturning method "+method);

		System.out.println("++++++++++++>Result :"+result);
		
		convertToUpperCase(result);
	}


	private void convertToUpperCase(List<Account> result) {
		for (Account account : result){
			String upperName = account.getName().toUpperCase();
			
			account.setName(upperName);
		}
	}		
	
	
	@AfterThrowing(
			pointcut="execution(* com.home.aopdemo.dao.AccountDAO.findAccounts(..))",
			throwing="theException")
	public void afterThrowingAdvice(
			JoinPoint joinPoint, Throwable theException){
		
		String method = joinPoint.getSignature().toShortString();
		System.out.println("************>Execute @AfterThrowing throwing exception on method: "+method);

		System.out.println("The exception is: "+theException);
	}
	
	
	
	
	
}
