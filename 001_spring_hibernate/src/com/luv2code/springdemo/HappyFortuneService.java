package com.luv2code.springdemo;

import java.util.ArrayList;
import java.util.Random;

public class HappyFortuneService implements FortuneService {
	

	@Override
	public String getFortune() {
		
		Random rand = new Random();

		return "Your lucky day";
	}

}
