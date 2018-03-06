package com.home.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;


// allow you to define a bean and its name for the id
@Component
public class TennisCoach implements Coach {
    
	@Autowired
	@Qualifier("randomFortuneService")
	private FortuneService fortuneService;

	  
	// define a default constructor
	public TennisCoach() {
		super();
		System.out.println(">> TennisCoach: inside default constructor");
	}
	
//	 define the setter method
//	@Autowired
//	public void setFortuneService(FortuneService fortuneService) {
//		this.fortuneService = fortuneService;
//		System.out.println(">> TennisCoach: inside setFortuneService()");
//	}



	@Override
	public String getDailyWorkout() {
		return "Practice your backhand volley";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return fortuneService.getFortune();
	}

}
