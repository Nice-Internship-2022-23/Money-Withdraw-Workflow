package com.microservice.Workflow.Starter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.Workflow.Starter.services.workflowStarterService;
import com.microservice.Workflow.Starter.services.Entities.Account;

@RestController
@RequestMapping("/workflowstarter")
public class workflowStarterController {
    
    @Autowired
    private workflowStarterService starterService;
    
    @GetMapping
    public String home(){
        return starterService.home();
    }

    @PostMapping
    public String startWorkFlow(@RequestBody Account account){
        return starterService.startWorkFlow(account);
    }
}
