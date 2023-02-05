package com.microservice.Workflow.Worker.service;

import com.microservice.Workflow.Worker.Entities.Account;

public interface workflowWorkerService {
    
    public String home();
    
    public boolean callAccountCheckActivity(String account_number);

    public boolean callVerifyUserActivity(Account account);

    public String callWithdrawAmountActivity(Account account, String amount);

}
