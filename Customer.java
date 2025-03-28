/**
 * 
 */
package edu.ilstu;
import java.util.Random;
/**
 * @author ijorda2
 *
 */
public class Customer {
	//Instance Variables
	int customerID;
	String firstName;
	String lastName;
	String firstLast;
	String ssn;
    Account[] account;
    int accountArraySize;
    CD[] cD;
    int cdArraySize;
    
    //Static Variables
    int[] randAccountNum = new int[20];
    int randAccountnumArraySize;
    
    public Customer(String firstName, String lastName, String ssn, Account[] account, CD[] cd) {
    	this();
    }
    
    public Customer(String firstName, String lastName, String ssn, Account[] account) {
    	
    	this();
    }
    
    public Customer(String firstName, String lastName, String ssn ) {
    	this();
    }
    
    public Customer() {
    	this.firstName = firstName;
    	this.lastName = lastName;
    	this.firstLast = firstName + " " + lastName;
    	this.ssn = ssn;
    	this.customerID = createCustIDNumber();
    	
    	cD = new CD[10];
    	account = new Account[5];
    }
    
    
    
    //Method to Randomly Generate Customer ID
    public int createCustIDNumber() {
    	   	   	
    	Random rand = new Random();
 
    	int randomNumber = rand.nextInt(9999);    	       	       	    	
    	return randomNumber;
    }
    
    public void addAccount(double balance, String type) {
    
    this.account[accountArraySize] = new Account(this.firstLast, balance, type );
    accountArraySize++;	
    }
    
    public void addCD(CD cd) {
    
    this.cD[cdArraySize] = new CD(cd.getOwnerName(), cd.getStartingAmount(),cd.getDuration());   	
    cdArraySize++;
    }
 //Getters**********************************   
    
    //Gets Customer ID
    public int getCustomerID() {	    	    	
    	return customerID;
    }
    
    //Gets Customer Name
    public String getName() {	
    	return firstLast;
    }
    
    //Gets Customer Social Security Number
    public String getSSN() {
    	return ssn;
    }
    
    public int getAccountSize() {
    	return accountArraySize;
    }
    
//Setters
    
    public void setFirstName(String firstName) {
    	this.firstName = firstName;
    }
    
    public void setLastName(String lastName) {
    	this.lastName = lastName;
    }
    
    public void setSsn(String ssn) {
    	this.ssn = ssn;
    }
    
    public String toString() {    	
    	
    	String toString =  "Customer Name: " + firstName + " " + lastName + "\n" +   			
    	"Customer ID Number: " + customerID + "\n" +    	
    	"Social Security Number: " + ssn + "\n" +    	 
    	"Accounts: " ;
    	
    	
    	toString += (accountArraySize == 0) ? "No accounts. \n" + "Account size: " + accountArraySize + "\n"
    			:  "Number of Accounts are: " + accountArraySize + "\n" + "Account size: " + accountArraySize + "\n";
    	
    	   	
    	toString += "CD's: ";
    	
    	if(cdArraySize == 0) {
    		toString += "No CD accounts. \n";
    		toString +="CD size: " + cdArraySize + "\n";
    	}
    	else
    	{
    		toString += "Number of CD accounts are: " + cdArraySize + "\n";
    		toString +="CD size: " + cdArraySize + "\n";
    	}
    	return toString;
    }
  
}
