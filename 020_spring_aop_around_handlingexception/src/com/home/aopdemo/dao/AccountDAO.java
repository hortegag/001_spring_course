package com.home.aopdemo.dao;

import java.util.ArrayList;
import java.util.List;

import javax.management.RuntimeErrorException;

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
	

	public void getExample(){
		System.out.println("Example of get");
	}
	
	public void setExample(){
		System.out.println("Example of set");
	}
	
	
	public List<Account> findAccounts(boolean generateException){
		List<Account> accounts = new ArrayList<>();
		
		if(generateException){
			
			throw new RuntimeException("Error procesinng the account");
		}
		Account account = new Account("Naruto","Silver");

		Account accountTwo = new Account("Kakashi","Gold");
		
		accounts.add(account);
		
		accounts.add(accountTwo);
		
		return accounts;
		
	}
	
}
