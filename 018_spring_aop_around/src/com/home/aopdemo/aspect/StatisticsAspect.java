package com.home.aopdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.home.aopdemo.Account;

@Aspect
@Component
@Order(1)
public class StatisticsAspect {
	

	
	// point cut expression match any class and any method with any parameters
	// combingin point cut declarations
	@Before("com.home.aopdemo.aspect.AOPAspectExpression.forDaoPackageNoGetterSetter()")
	public void beforeMatchPackage(JoinPoint joinPoint){
		System.out.println("/////////////> Collecting statistics");
		
		// display method signature
		MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
		
		System.out.println("Method Signature: "+methodSignature);
		
		
		// display method arguments
	//	methodSignature.get
		Object[] arguments = joinPoint.getArgs();
		System.out.println("\n\n\nMethod parameters");

		for (Object argument : arguments){
			System.out.println(argument);
			
			if(argument instanceof Account){
				Account account = (Account) argument;
				System.out.println("Accout object"+account);
			}
			

		}
		
		
		
	}
	

}
