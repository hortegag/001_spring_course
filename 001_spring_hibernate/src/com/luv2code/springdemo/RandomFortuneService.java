package com.luv2code.springdemo;

import java.util.ArrayList;
import java.util.Random;

public class RandomFortuneService implements FortuneService {
	
	String[] myStringArray= new String[]{"Your lucky day","Your day is so-so","Your bad day"};

	@Override
	public String getFortune() {
		
		Random rand = new Random();

		return myStringArray[rand.nextInt(2) + 1];
		//return "testt";
	}

}
