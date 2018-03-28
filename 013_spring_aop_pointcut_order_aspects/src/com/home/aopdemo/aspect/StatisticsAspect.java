package com.home.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class StatisticsAspect {
	

	
	// point cut expression match any class and any method with any parameters
	// combingin point cut declarations
	@Before("com.home.aopdemo.aspect.AOPAspectExpression.forDaoPackageNoGetterSetter()")
	public void beforeMatchPackage(){
		System.out.println("/////////////> Collecting statistics");
	}
	

}
