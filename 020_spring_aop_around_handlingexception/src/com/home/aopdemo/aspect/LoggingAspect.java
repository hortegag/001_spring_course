package com.home.aopdemo.aspect;

import java.util.List;
import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.home.aopdemo.Account;

@Aspect
@Component
@Order(15)
public class LoggingAspect {
	
	private Logger myLogger = Logger.getLogger(LoggingAspect.class.getName());
	
	@Around("execution(* com.home.aopdemo.service.*.getFortune(..))")
	public Object aroundGetFortune(ProceedingJoinPoint theJointPoint) throws Throwable{
		
		String method = theJointPoint.getSignature().toShortString();
		myLogger.info("<<<<<<<<<<<<< @Around Execute after method "+method);
		
		long begin = System.currentTimeMillis();
		
		Object result = null;

		try {
			result = theJointPoint.proceed();
		} catch (Exception e) {

			// log the exception
			
			myLogger.warning(e.getMessage());
			
			// give user a custom message
			result = "Major accident , private aop helicopter on the way";
		}
		
		long end = System.currentTimeMillis();
		
		//compute duration
		long duration = end - begin;
		myLogger.info("\n -<-<--<--<Duration: "+duration/1000.0+"seconds ");
		
		
	
		
		return result;
		
	}
	
	@After("execution(* com.home.aopdemo.dao.AccountDAO.findAccounts(..))")
	public void afterFinally(JoinPoint joinPoint){
		
		
		String method = joinPoint.getSignature().toShortString();
		myLogger.info("<<<<<<<<<<<<< @After Execute after method "+method);

	
		
	}

	// point cut expression match any class and any method with any parameters
	// combingin point cut declarations
	@Before("com.home.aopdemo.aspect.AOPAspectExpression.forDaoPackage()")
	public void beforeMatchPackage(){
		myLogger.info(">>>>>>>>>>>>>>Excuting before any add method");
	}	
	

	@AfterReturning(
			pointcut="execution(* com.home.aopdemo.dao.AccountDAO.findAccounts(..))",
			returning="result")
	public void afterReturnFindAccounts(
			JoinPoint joinPoint, List<Account> result){
		
		String method = joinPoint.getSignature().toShortString();
		myLogger.info("++++++++++++>Execute after @AfterReturning method "+method);

		myLogger.info("++++++++++++>Result :"+result);
		
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
		myLogger.info("************>Execute @AfterThrowing throwing exception on method: "+method);

		myLogger.info("The exception is: "+theException);
	}
	
	
	
	
	
}
