package com.home.aopdemo.service;

import java.util.concurrent.TimeUnit;

import javax.management.RuntimeErrorException;

import org.springframework.stereotype.Component;

@Component
public class TrafficFortuneService {
	
	
	public String getFortune(){
		
		try {
			TimeUnit.SECONDS.sleep(6);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "Heavy traffic on the streets";
		
	}

	public String getFortune(boolean generateException) {
		// TODO Auto-generated method stub
		
		
		if (generateException){
			
			throw new RuntimeException("Major accident! Highway is closed");
			
		}
		
		return getFortune();
	}

}
