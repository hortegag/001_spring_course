package com.luv2code.springdemo;

public class CrossFitCoach implements Coach {
	
	FortuneService fortuneService;
	
	

	public CrossFitCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "Workout Cricket";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return fortuneService.getFortune();
	}

}
