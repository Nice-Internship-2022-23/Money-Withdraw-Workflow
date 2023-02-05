package com.microservice.Activity.Worker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.Activity.Worker.Entities.Account;
import com.microservice.Activity.Worker.service.activityWorkerService;

@RestController
@RequestMapping("/activityworker")
public class activityWorkerController {
    
    @Autowired
    private activityWorkerService workerService;

    @GetMapping
    public String home(){
        return workerService.home();
    }

    @PostMapping("/check")
    public boolean checkAccount(@RequestBody Account account){
        try {
            return workerService.CheckAccount(account.getAccountNumber());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    @PostMapping("/verify")
    public boolean verifyAccount(@RequestBody Account account){
        return workerService.VerifyAccount(account);
    }

    @PostMapping("/withdraw")
    public String withdrawAmount(@RequestBody Account account){
        return workerService.WithdrawAmount(account);
    }
}
