package com.home.springdemo;

import org.springframework.stereotype.Component;


// allow you to define a bean and its name for the id
@Component("thatSillyCoach")
public class TennisCoach implements Coach {

	@Override
	public String getDailyWorkout() {
		return "Practice your backhand volley";
	}

}
