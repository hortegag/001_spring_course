package com.home.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class AccountDAO {

	public void addAccount(){
		System.out.println(AccountDAO.class+" adding an accout");
	}
}
