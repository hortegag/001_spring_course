package com.luv2code.springdemo;

public class BaseballCoach implements Coach {
	
	// defin private field for the dependency
	private FortuneService fortuneService;
	
	// define a constructor for dependency injection
	public BaseballCoach(FortuneService theFortuneService) {
		// TODO Auto-generated constructor stub
		fortuneService = theFortuneService;
		
	}
	
	
	@Override
	public String getDailyWorkout(){
		return "Spend 30 minutes on batting practice";
	}

	@Override
	public String getDailyFortune() {

		// using my fortuneService to get a fortune
		
		return fortuneService.getFortune();
	}
	
	

}
