package com.home.springdemo;

import org.springframework.stereotype.Component;

@Component
public class CrossFitCoach implements Coach {

	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "Make 30 push ups";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return null;
	}

}
