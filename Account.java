package edu.ilstu;

import java.text.DecimalFormat;

public class Account {
	public static int totalAccounts=0;
    private int accountNumber;
    private String ownerName;
    private double balance;
    private String accountType;
    

    public Account(String ownerName, double balance, String type) {     
    	totalAccounts++;
        this.ownerName = ownerName;
        this.balance = balance;
        this.accountNumber = totalAccounts;
        this.accountType = type;
              
    }
    public int getAccountNumber() {
        return accountNumber;
    }
    
    public String getOwnerName() {
        return ownerName;
    }
    public double getBalance() {
        return balance;
    }
    public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposit successful. New balance: $" + balance + "\n");
    }
    public void withdraw(double amount) {
        if (balance >= amount) 
        {
            balance -= amount;
            System.out.println("Withdrawal successful. New balance: $" + balance + "\n");
        } 
        else 
        {
            System.out.println("Insufficient funds. Withdrawal failed.");
        }
    }
   
    
    public String toString()
    {
    	DecimalFormat acctF = new DecimalFormat("0000");
    	DecimalFormat df = new DecimalFormat("$##0.00");
    	String output = "\tAccount Number: " + acctF.format(accountNumber) + 
    			"\n\tOwner Name: " + ownerName + 
    			"\n\tAccount Type: " + accountType +
    			"\n\tBalance: " + df.format(balance) +"\n";
    	return output;
    }
    
   

}
