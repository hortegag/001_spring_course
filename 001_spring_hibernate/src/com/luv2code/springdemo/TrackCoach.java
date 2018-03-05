package com.luv2code.springdemo;

public class TrackCoach implements Coach {
	
	private FortuneService fortuneService;

	
	public TrackCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	public TrackCoach() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getDailyWorkout() {
		return "Run a hard 5k";
	}

	@Override
	public String getDailyFortune() {
		return "Just Do It: "+fortuneService.getFortune();
	}
	
	
	// add an init mehod
	public void doMyStartupStuff(){
		System.out.println("TrackCoach: inside method: doMyStartupStuff");
	}
	
	
	// add a destroy method
	public void doMyCleanUpStuff(){
		System.out.println("TrackCoach: inside method: doMyCleanUpStuff");
	}


}
