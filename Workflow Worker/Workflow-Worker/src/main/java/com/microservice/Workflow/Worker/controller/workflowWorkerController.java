package com.microservice.Workflow.Worker.controller;

import org.json.*;

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
    public String activityCall(@RequestBody String input){
        try {
            JSONObject object = new JSONObject(input);
            if(object.has("ACCOUNT_NUMBER")){
                acc_no = object.get("ACCOUNT_NUMBER").toString();
            } 
            if(object.has("PASSWORD")){
                password = object.get("PASSWORD").toString();
            } 
            if(object.has("AMOUNT")){
                amount = object.get("AMOUNT").toString();
            } 
            if(object.has("IS_VERIFIED")){
                IS_VERIFIED = (boolean) object.get("IS_VERIFIED");
            }
            if(object.has("IS_ACCOUNT_EXIST")){
                IS_ACCOUNT_EXIST = (boolean) object.get("IS_ACCOUNT_EXIST");
            }

            if(!IS_ACCOUNT_EXIST){
                if(acc_no != null){
                    IS_ACCOUNT_EXIST = workerService.callAccountCheckActivity(acc_no);
                    if(!IS_ACCOUNT_EXIST) return "Account does not exist";
                    return "Enter PIN number!";
    
                }
                else{
                    return "Error in account check.";
                }
            }

            if(!IS_VERIFIED){
                if(password != null){
                    IS_VERIFIED = workerService.callVerifyUserActivity(new Account(acc_no, password));
                    if(!IS_VERIFIED) return "Wrong PIN Inserted";
                    return "Enter amount";

                } 
                else{
                    return "Enter Withdraw amount!";
                }
            }
            
            if(IS_VERIFIED && IS_ACCOUNT_EXIST){
                System.out.println("Amount : " + amount);
                if(amount != null){
                    return workerService.callWithdrawAmountActivity(new Account(acc_no, password), amount);
                } else{
                    return "Enter amount:";
                }
            } else{
                return "Error during process!";
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        return "No Output";
    }
}
