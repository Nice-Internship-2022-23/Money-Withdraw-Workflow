package com.microservice.Workflow.Starter.services;

import com.microservice.Workflow.Starter.services.Entities.Account;

public interface workflowStarterService {
    
    public String home();
    
    public String startWorkFlow(Account account);
}
