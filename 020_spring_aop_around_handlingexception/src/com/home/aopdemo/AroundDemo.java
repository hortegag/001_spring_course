package com.home.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.home.aopdemo.dao.AccountDAO;
import com.home.aopdemo.service.TrafficFortuneService;

public class AroundDemo {

	public static void main(String[] args) {
		
		
		// read spring config java class
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		TrafficFortuneService theFortuneService =
				context.getBean("trafficFortuneService",TrafficFortuneService.class);
		
		System.out.println("Calling fortune service");
		System.out.println(theFortuneService.getFortune());
		
		// close the context
		context.close();

	}

}
