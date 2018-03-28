package com.home.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

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
	

	
	
	
	
	
}
