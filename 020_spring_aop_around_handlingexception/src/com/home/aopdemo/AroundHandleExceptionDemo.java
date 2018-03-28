package com.home.aopdemo;

import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.home.aopdemo.service.TrafficFortuneService;

public class AroundHandleExceptionDemo {
	
	private static Logger myLogger = Logger.getLogger(AroundHandleExceptionDemo.class.getName());
	

	public static void main(String[] args) {
		
		
		// read spring config java class
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		TrafficFortuneService theFortuneService =
				context.getBean("trafficFortuneService",TrafficFortuneService.class);
		
		myLogger.info("Calling fortune service");
		boolean generateException = true;
		myLogger.info(theFortuneService.getFortune(generateException));
		myLogger.info("finishing");
		// close the context
		context.close();

	}

}
