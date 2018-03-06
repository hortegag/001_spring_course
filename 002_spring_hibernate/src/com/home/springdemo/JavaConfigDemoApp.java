package com.home.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JavaConfigDemoApp {

	public static void main(String[] args) {

		// read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);
		
		
		// get the bean from spring container
		Coach coach = context.getBean("tennisCoach",Coach.class);

		Coach crossFitCoach = context.getBean("crossFitCoach",Coach.class);
		
		
		
		// call a method on the bean
		System.out.println(coach.getDailyWorkout());
		
		System.out.println(crossFitCoach.getDailyWorkout());
		
		
		System.out.println(coach.getDailyFortune());
		
		//close the context
		context.close();
		
	}

}
