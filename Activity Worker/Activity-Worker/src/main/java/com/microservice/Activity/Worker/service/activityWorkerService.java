package com.microservice.Activity.Worker.service;

import com.microservice.Activity.Worker.Entities.Account;

public interface activityWorkerService{
    
    public String home();

    public boolean CheckAccount(String account_number);

    public boolean VerifyAccount(Account account);

    public String WithdrawAmount(Account account);
}
