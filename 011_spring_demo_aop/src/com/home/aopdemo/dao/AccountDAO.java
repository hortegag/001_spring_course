package com.home.aopdemo.dao;

import org.springframework.stereotype.Component;

import com.home.aopdemo.Account;

@Component
public class AccountDAO {

	public void addAccount(){
		System.out.println(AccountDAO.class+" adding an account");
	}
	
	
	public void addTestAccount(){
		System.out.println(AccountDAO.class+" adding a test account");
	}
	
	
	public void addNewAccount(Account account) {
		
		System.out.println("adding the new account" +account);
		
	}
	
	public void addNewAccount(Account theAccount, boolean vipFlag) {		
		System.out.println("adding the new account verifyn importan persons");

	}
	
	
	
	
}
