package com.home.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {

	public void addAccount(){
		System.out.println(getClass()+" adding a membership account");
	}
	
	public String addTesMemberAccount(){
		System.out.println(getClass()+" adding a membership account");
		return "test member";
	}
}
