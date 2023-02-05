package com.microservice.Workflow.Starter.services;

import org.json.JSONObject;
import org.springframework.stereotype.Service;


@Service
public class workflowStarterServiceImpl implements workflowStarterService{

    @Override
    public String startWorkFlow(String account_number) {
        try {
            JSONObject jsonObject = new JSONObject(account_number);
            String acc_no = (String) jsonObject.get("ACCOUNT_NUMBER");
            System.out.println("Account Number :" + acc_no);
            return "Account Exist : \nAccount Number : " + acc_no + "\n" + account_number ;
            } catch (Exception e) {
            e.getMessage();
        }
        
        return "Account Not Exist";
    }

    @Override
    public String home() {
        return "Welcome to WorkFlow Starter";
    }
    
}
