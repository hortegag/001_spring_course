package com.home.aopdemo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.home.aopdemo.Account;

@Aspect
@Component
@Order(15)
public class LoggingAspect {
	

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
		System.out.println("++++++++++++>Execute after method "+method);

		System.out.println("++++++++++++>Result :"+result);
		
		convertToUpperCase(result);
	}


	private void convertToUpperCase(List<Account> result) {
		for (Account account : result){
			String upperName = account.getName().toUpperCase();
			
			account.setName(upperName);
		}
	}		
	
	
	
	
	
	
	
}
