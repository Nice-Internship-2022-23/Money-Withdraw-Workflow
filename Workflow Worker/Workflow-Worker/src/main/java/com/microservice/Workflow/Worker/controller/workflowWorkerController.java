package com.microservice.Workflow.Worker.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.Workflow.Worker.Entities.Account;
import com.microservice.Workflow.Worker.service.workflowWorkerService;

@RestController
@RequestMapping("/workflowworker")
public class workflowWorkerController {
    
    private String acc_no, password, amount;
    
    private boolean IS_VERIFIED = false, IS_ACCOUNT_EXIST = false;

    @Autowired
    private workflowWorkerService workerService;

    @GetMapping
    public String home(){
        return workerService.home();
    }

    @PostMapping
    public String activityCall(@RequestBody Account account){
    	System.out.println(account.isVerified());
        try {
        	if(account.getAccountNumber() == null || account.getAccountPin() == null || account.getWithdrawAmount() == null) {
        		return "All fields should be filled";
        	}
        	else {
        		acc_no = account.getAccountNumber();
        		password = account.getAccountPin();
        		amount = account.getWithdrawAmount();
        		IS_VERIFIED = account.isVerified();
        		IS_ACCOUNT_EXIST = account.isAccountExist();
        	}

            if(!IS_ACCOUNT_EXIST){
                if(acc_no != null){
                    IS_ACCOUNT_EXIST = workerService.callAccountCheckActivity(account);
                    if(!IS_ACCOUNT_EXIST) return "Account does not exist";    
                }
                else{
                    return "Error in account check.";
                }
            }

            if(!IS_VERIFIED){
                if(password != null){
                    IS_VERIFIED = workerService.callVerifyUserActivity(account);
                    if(!IS_VERIFIED) return "Wrong PIN Inserted";
                } 
                else{
                    return "Enter Withdraw amount!";
                }
            }
            
            if(IS_VERIFIED && IS_ACCOUNT_EXIST){
                if(amount != null){
                    return workerService.callWithdrawAmountActivity(account);
                } else {
                	return "";
                }
            } else{
                return "Error during process!";
            }
        } catch (Exception e) {
            return e.getMessage().toString();
        }
    }
}
