package com.microservice.Activity.Worker.service;

import org.springframework.stereotype.Service;

import com.microservice.Activity.Worker.Entities.Account;

@Service
public class activityWorkerServiceImpl implements activityWorkerService{

	private final String ACCOUNT_NUMBER = "603259874530";
    private final String ACCOUNT_PIN = "sl39zi";
    private final int ACCOUNT_BALANCE = 50000;

    @Override
    public String home() {
        return "This is Activity Worker.";
    }

    @Override
    public boolean CheckAccount(Account account) {
    	System.out.println(account.getAccountNumber());
        if(account.getAccountNumber().equals(ACCOUNT_NUMBER)) {
        	return true;
        }
        else return false;
    }

    @Override
    public boolean VerifyAccount(Account account) {
    	if(account.getAccountNumber().equals(ACCOUNT_NUMBER) && account.getAccountPin().equals(ACCOUNT_PIN)) {
    		return true;
    	}
        return false;
    }

    @Override
    public String WithdrawAmount(Account account) {
    	if(Integer.parseInt(account.getWithdrawAmount()) >= 100 && Integer.parseInt(account.getWithdrawAmount()) <= ACCOUNT_BALANCE) {
    		return "Withdrawal amount = " + account.getWithdrawAmount() + " is successful";
    	}
        return "Balance not available";
    }
    
}
