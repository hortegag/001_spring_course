package com.home.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogginAspect {
	
	// realated advices for loggin
	
	// @Before advice
	
	@Before("execution(public void addAccount())")
	public void beforeAddAccountAdvice(){
		System.out.println("========>Excuting before advice method \n\n\n");
	}

}
