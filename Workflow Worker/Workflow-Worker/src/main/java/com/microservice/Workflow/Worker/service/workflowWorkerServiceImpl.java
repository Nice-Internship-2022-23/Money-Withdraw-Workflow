package com.microservice.Workflow.Worker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.microservice.Workflow.Worker.Entities.Account;

@Service
public class workflowWorkerServiceImpl implements workflowWorkerService{

	@Autowired
    private RestTemplate restTemplate;
	
    
    @Override
    public boolean callAccountCheckActivity(Account account) {
    	System.out.println(account.getAccountNumber());
    	try {    	
            String url = "http://localhost:8083/activityworker/check";
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);

            HttpEntity<String> entity = new HttpEntity<String>(account.getAccountNumber(),headers);
            
            boolean response = restTemplate.postForObject(url, entity, Boolean.class);
            System.out.println("Response from worker: " + response);

            return response;
	
		
		} catch (Exception e) {
				System.out.println("Error in account check : " + e.getMessage());
	            return false;
	    }
    }

    @Override
    public boolean callVerifyUserActivity(Account account) {
    	try {    	
            String url = "http://localhost:8083/activityworker/verify";
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);

            HttpEntity<Account> entity = new HttpEntity<Account>(account,headers);
            
            boolean response = restTemplate.postForObject(url, entity, Boolean.class);
            System.out.println("Response from worker: " + response);

            return response;
	
		
		} catch (Exception e) {
			System.out.println("Error in verify account " + e.getMessage());
	        return false;
	    }
    }

    @Override
    public String callWithdrawAmountActivity(Account account) {
    	try {    	
            String url = "http://localhost:8083/activityworker/withdraw";
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);

            HttpEntity<Account> entity = new HttpEntity<Account>(account,headers);
            
            String response = restTemplate.postForObject(url, entity, String.class);
            System.out.println("Response from worker: " + response);

            return response;
	
		
		} catch (Exception e) {
	            return e.getMessage().toString();
	    }
    }

    @Override
    public String home() {
        return "This is workflow worker.";
    }
    
}
