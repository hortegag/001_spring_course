package com.home.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class AccountDAO {

	public void addAccount(){
		System.out.println(AccountDAO.class+" adding an account");
	}
	
	
	public void addTestAccount(){
		System.out.println(AccountDAO.class+" adding a test account");
	}
}
