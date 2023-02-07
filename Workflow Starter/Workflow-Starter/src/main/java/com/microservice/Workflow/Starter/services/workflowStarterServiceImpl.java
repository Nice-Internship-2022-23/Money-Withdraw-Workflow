package com.microservice.Workflow.Starter.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.microservice.Workflow.Starter.services.Entities.Account;



@Service
public class workflowStarterServiceImpl implements workflowStarterService{

	@Autowired
    private RestTemplate restTemplate;

    @Override
    public String home() {
        return "Welcome to WorkFlow Starter";
    }

	@Override
	public String startWorkFlow(Account account) {
		try {    	
            String url = "http://localhost:8082/workflowworker/";
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
    
}
