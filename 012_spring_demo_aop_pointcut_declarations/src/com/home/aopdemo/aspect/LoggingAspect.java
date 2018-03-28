package com.home.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
	
	@Pointcut("execution(* com.home.aopdemo.dao.*.*(..))")
	public void forDaoPackage(){}
	
	
	@Pointcut("execution(* com.home.aopdemo.dao.*.get*(..))")
	private void getter(){}

	@Pointcut("execution(* com.home.aopdemo.dao.*.set*(..))")
	private void setter(){}
	
	@Pointcut("forDaoPackage() && ! (getter() || setter())")
	private void forDaoPackageNoGetterSetter(){}
	
	// point cut expression match any class and any method with any parameters
	// combingin point cut declarations
	@Before("forDaoPackageNoGetterSetter()")
	public void beforeMatchPackage(){
		System.out.println(">>>>>>>>>>>>>>Excuting before any add method");
	}	
	
	@Before("forDaoPackage()")
	public void collectAnalytics(){
		System.out.println("=======> collecting analytics");
	}
	
	
	
	
	
}
