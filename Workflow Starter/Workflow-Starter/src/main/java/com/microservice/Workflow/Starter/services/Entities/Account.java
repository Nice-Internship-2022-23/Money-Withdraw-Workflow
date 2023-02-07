package com.microservice.Workflow.Starter.services.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    private String accountNumber;
    private String accountPin;
    private String withdrawAmount;
    private boolean isVerified, isAccountExist;
    

	public Account(String accountNumber, String accountPin) {
    	this.accountNumber = accountNumber;
    	this.accountPin = accountPin;
    }
	
	public Account(String accountNumber, String accountPin, String withdrawAmount) {
		super();
		this.accountNumber = accountNumber;
		this.accountPin = accountPin;
		this.withdrawAmount = withdrawAmount;
	}
    
    public Account() {
		super();
	}

	public Account(String accountNumber, String accountPin, String withdrawAmount, boolean isVerified,
			boolean isAccountExist) {
		super();
		this.accountNumber = accountNumber;
		this.accountPin = accountPin;
		this.withdrawAmount = withdrawAmount;
		this.isVerified = isVerified;
		this.isAccountExist = isAccountExist;
	}

	public boolean isVerified() {
		return isVerified;
	}

	public void setVerified(boolean isVerified) {
		this.isVerified = isVerified;
	}

	public boolean isAccountExist() {
		return isAccountExist;
	}

	public void setAccountExist(boolean isAccountExist) {
		this.isAccountExist = isAccountExist;
	}

	public String getWithdrawAmount() {
		return withdrawAmount;
	}

	public void setWithdrawAmount(String withdrawAmount) {
		this.withdrawAmount = withdrawAmount;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccountPin() {
		return accountPin;
	}

	public void setAccountPin(String accountPin) {
		this.accountPin = accountPin;
	}
    
    
}
