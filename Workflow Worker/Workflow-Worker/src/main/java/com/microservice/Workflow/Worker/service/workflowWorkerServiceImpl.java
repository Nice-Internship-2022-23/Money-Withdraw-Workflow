package com.microservice.Workflow.Worker.service;

import org.springframework.stereotype.Service;

import com.microservice.Workflow.Worker.Entities.Account;

@Service
public class workflowWorkerServiceImpl implements workflowWorkerService{

    @Override
    public boolean callAccountCheckActivity(String account_number) {
        return false;
    }

    @Override
    public boolean callVerifyUserActivity(Account account) {
        return false;
    }

    @Override
    public String callWithdrawAmountActivity(Account account, String amount) {
        return "Amount = " + amount;
    }

    @Override
    public String home() {
        return "This is workflow worker.";
    }
    
}
