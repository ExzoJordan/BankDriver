/**
 * 
 */
package edu.ilstu;
import java.util.Scanner;
/**
 * @author ijorda2
 *
 */
public class BankDriver {

	/**
	 * @param args
	 */
	public static Scanner scnr = new Scanner (System.in);
	public static Customer[] customers = new Customer[20]; 
	public static int choice;
	public static int customerCount=0;	
	public static void main(String[] args) {
	//Variables
	
		  

	for (int i = 0; i < customers.length; i++) {
	    customers[i] = new Customer();  // Initialize each element with a default Customer		   
	}
		
	while(choice != 7) {
		
		displayMenu();
		
		switch (choice) {
		
		case 1:
		createNewCustomer();		
		break;
		
		case 2:		
		createAccount();
		break;
		
		case 3:
		deposit();
		break;
		
		case 4:
		withdraw();	
		break;
		
		case 5:
		createCD();	
		break;
		
		case 6:
		for(int i =0 ; i<20;i++) {
			System.out.println("Customer " + i + " " + customers[i].getName() + " " + customers[i].getCustomerID());
		}
		break;
		
		case 7:
		System.out.println("Good bye ");
		
		default:
			System.out.println("Enter a valid number: ");
		break;
		
		}
		
	}
		
		
		
		
		
		

	}
	
	
	//Create New Customer method
	public static void createNewCustomer() {
		
	String firstName;
	String lastName;
	String ssn;
	
	firstName = scnr.nextLine();
	System.out.println("Enter first name: ");
	firstName = scnr.nextLine();
	
	System.out.println("Enter last name: ");
	lastName = scnr.nextLine();
	
	System.out.println("Enter Social Security Number: ");
	ssn = scnr.nextLine();
	
	customers[customerCount] = new Customer();
	customers[customerCount].setFirstName(firstName);
	customers[customerCount].setLastName(lastName);
	customers[customerCount].setSsn(ssn);
	
	System.out.println(customers[customerCount].toString());
	
	
	customerCount ++;
		
	}
//Create a new account	method*******************
	public static void createAccount() {
	
	int customer = 0 ;
	int id = 0;
	double deposit = 0;
	String type = " ";
	int answer = 0;
	boolean idFound = false;
		
	System.out.println("Enter Customer ID: ");
	id = scnr.nextInt();
	
	System.out.println("Enter Deposit Amount: ");
	deposit	= scnr.nextInt();
	
	while(answer != 1 && answer != 2) {
	System.out.println("Would you like a checking or savings account? ");
	System.out.println("Enter 1 for checking and 2 for savings:");
	answer = scnr.nextInt();
	}
	if(answer == 1) {
		type ="Checking";
	}
	if(answer == 2) {
		type = "Savings";
	}
		
	//Gets ID and scans to see a match with customer arrays
	 for (int i = 0; i <= customerCount; i++) {				
		 if (customers[i].getCustomerID() == id) {
		
	    	customer = i;
		
		    customers[i].addAccount(deposit , type);
		    idFound = true;
		    
		    System.out.println(customers[i].account[Account.totalAccounts]);
		 
		    System.out.println(customers[i].toString());		 
		 }				 
	 }
	 
	//If Customer ID doesn't match any show ID not found.
	 if(idFound == false) {
		 System.out.println("ID not found ");
	 }
	 
	 if(idFound == true) {		 
		System.out.println("Account created! ");			
	 }	 
	}
	
	//Deposit Method***********************
	public static void deposit() {
		int id = 0;
		double deposit = 0;
		int accountNum = 0;
										
		System.out.println("Enter Customer ID: ");
		id = scnr.nextInt();
		
		System.out.println("Enter Deposit amount: ");
		deposit = scnr.nextDouble();
		 
		 for (int i = 0; i < customerCount; i++) {			 
			
			 if (customers[i].getCustomerID() == id) {
				 
				 System.out.println("Enter Account number: ");
				 accountNum = scnr.nextInt();
				
				 if(accountNum<customers[i].accountArraySize) {
					
					customers[i].account[accountNum-1].deposit(deposit);
				 } 
				 
				 System.out.println(customers[i].toString()); 
				 			 
		 }
	}
	}
	
	//Withdraw method************************
	public static void withdraw() {
		
		int id = 0;
		int accountNum;
		double withdraw;
		
		System.out.println("Enter Customer ID: ");
		id = scnr.nextInt();
		
		System.out.println("Enter withdraw amount: ");
		withdraw = scnr.nextDouble();
		
		 for (int i = 0; i < 20; i++) {		 
			 if (customers[i].getCustomerID() == id) {
				
				 System.out.println("Enter Account number: ");
				 accountNum = scnr.nextInt();
				
				 if(accountNum<customers[i].accountArraySize) {										 
					 customers[i].account[accountNum-1].withdraw(withdraw);
					 System.out.println(customers[i].toString());
				 }				 
			 }						 
		 }		 
	}
	
	
	//Create CD Method**************************************8
	public static void createCD() {
		
		int id = 0;
		
		System.out.println("Enter Customer ID: ");
		id = scnr.nextInt();
		
		for (int i = 0; i < 20; i++) {
			 
			 if (customers[i].getCustomerID() == id) {
				 			
			 }						 
		 }
	}
	
	//Display Menu Method**************************************
	public static void displayMenu() {
						
	System.out.println("Welcome to ISU Bank. What would you like to do? \n");	
	System.out.println("1- New Customer ");	
	System.out.println("2- Open an account ");	
	System.out.println("3- Make a deposit ");	
	System.out.println("4- Make a withdraw ");	
	System.out.println("5- Create a CD ");	
	System.out.println("6- Display customer information");	
	System.out.println("7- Quit ");
	
	if(scnr.hasNextInt()) {
	choice = scnr.nextInt();
	}
	else {
    scnr.next();
	choice = 0;
	}
	
	
	
		
		
		
	}
	
		
		
	}


