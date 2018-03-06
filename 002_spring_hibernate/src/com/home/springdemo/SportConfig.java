package com.home.springdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
//To use the bean that are manually define
//@ComponentScan("com.home.springdemo")
public class SportConfig {


		// define bean for our sad fortun Service
		//The name of the method is the name of the bean
		@Bean
		public FortuneService sadFortuneService(){
			return new SadFortuneService();
		}
		
		// define bean for our swim coach and inject dependency
		@Bean
		public Coach swimCoach(){
			return new SwimCoach(sadFortuneService());
		}

}
