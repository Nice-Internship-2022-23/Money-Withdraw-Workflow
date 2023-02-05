package com.microservice.Activity.Worker.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account {
    
    private String accountNumber;
    private String accountPin;
    private String withdrawAmount;
}
