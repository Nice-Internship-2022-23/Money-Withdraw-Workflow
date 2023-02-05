package com.microservice.Activity.Worker.service;

import org.springframework.stereotype.Service;

import com.microservice.Activity.Worker.Entities.Account;

@Service
public class activityWorkerServiceImpl implements activityWorkerService{

    private final String ACCOUNT_NUMBER = "623598741056";
    private final String ACCOUNT_PIN = "865234";
    private final int ACCOUNT_BALANCE = 50000;

    @Override
    public String home() {
        return "This is Activity Worker.";
    }

    @Override
    public boolean CheckAccount(String account_number) {
        System.out.println(account_number);
        if(account_number.equals(ACCOUNT_NUMBER)) return true;
        return false;
    }

    @Override
    public boolean VerifyAccount(Account account) {
        if(account.getAccountNumber().equals(ACCOUNT_NUMBER) && account.getAccountPin().equals(ACCOUNT_PIN)) return true;
        return false;
    }

    @Override
    public String WithdrawAmount(Account account) {
        int amt = Integer.parseInt(account.getWithdrawAmount());
        if(amt > ACCOUNT_BALANCE) return "Balance is not sufficient";
        if(account.getAccountNumber().equals(ACCOUNT_NUMBER) && account.getAccountPin().equals(ACCOUNT_PIN)) return account.getWithdrawAmount();
        return "Account not exist.";
    }
    
}
