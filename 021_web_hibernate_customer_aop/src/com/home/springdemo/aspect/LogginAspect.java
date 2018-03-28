package com.home.springdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.jboss.logging.Logger;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogginAspect {

	
	//set up logger
	private Logger myLogger = Logger.getLogger(getClass().getName());
	
	//set up pointcut declaration 
	@Pointcut("execution (* com.home.springdemo.controller.*.*(..))")
	public void forControllerPackage(){};
	
	@Pointcut("execution (* com.home.springdemo.service.*.*(..))")
	public void forServicePackage(){};

	@Pointcut("execution (* com.home.springdemo.dao.*.*(..))")
	public void forDAOPackage(){};

	
	@Pointcut("forControllerPackage() || forServicePackage() || forDAOPackage()")
	public void forAppFlow(){};
	
	// add @Before advice
	@Before("forAppFlow()")
	public void before(JoinPoint joinPoint){
		
		// display method
		String mehtod = joinPoint.getSignature().toShortString();
		myLogger.info("======> in @Before calling the  method"+mehtod);
		
		// display arguments
		Object[] objects = joinPoint.getArgs();
		
		for (Object argument : objects){
			System.out.println("argument: "+argument);
		}
		
		//
		
	}
	
	
	// add @AfterReturning advice
	
	@AfterReturning(
			pointcut="forAppFlow()",
			returning="theResult")
	public void afterReturning(JoinPoint joinPoint, Object theResult){
		
		String method = joinPoint.getSignature().toShortString();
		myLogger.info("++++++++++> in @AfterReturning: calling method: "+method);
		
		myLogger.info(".............> result:"+theResult);
		
	}
}
