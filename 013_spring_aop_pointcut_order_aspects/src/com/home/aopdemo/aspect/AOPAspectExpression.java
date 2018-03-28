package com.home.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AOPAspectExpression {
	
	@Pointcut("execution(* com.home.aopdemo.dao.*.*(..))")
	public void forDaoPackage(){}
	
	
	@Pointcut("execution(* com.home.aopdemo.dao.*.get*(..))")
	public void getter(){}

	@Pointcut("execution(* com.home.aopdemo.dao.*.set*(..))")
	public void setter(){}
	
	@Pointcut("forDaoPackage() && ! (getter() || setter())")
	public void forDaoPackageNoGetterSetter(){}
	

}
