package edu.ilstu;

import java.text.DecimalFormat;

public class CD {
	public static final int DURATION1 =6;
	public static final int DURATION2 = 12;
	public static final int DURATION3 = 15;
	public static final double INTEREST1 = .02;
	public static final double INTEREST2 = .035;
	public static final double INTEREST3 = .042;
	
	public static int totalCDs = 0;
	
	private int accountNumber;
	private String ownerName;
	private double startingAmount;
	private int duration;
	
	public CD( String ownerName, double startingAmount, int duration) {
		this.accountNumber = totalCDs+10000;
		this.ownerName = ownerName;
		if(startingAmount>0)
			this.startingAmount = startingAmount;
		else
			startingAmount =-1;
		if(duration==DURATION1||duration==DURATION2||duration==DURATION3)
			this.duration = duration;
		else
			duration = 0;
		
		totalCDs++;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public int getDuration() {
		return duration;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public double getStartingAmount() {
		return startingAmount;
	}

	
	private double determineInterest()
	{
		double interest=0;
		if(duration==DURATION1)
			interest = DURATION1;
		else if(duration==DURATION2)
			interest = DURATION2;
		else if(duration==DURATION3)
			interest = DURATION1;
		else
			interest =0;
		return interest;
		
	}
	
	public double determineBalance(int months)
	{
		if(months > duration)
			months = duration;
		double balance = startingAmount;
		double interest = determineInterest();
		for(int i=0; i< months; i++)
		{
			balance += balance * interest;
		}
		return balance;
	}
	public String toString()
	{
		DecimalFormat acctNum = new DecimalFormat("0000");
		DecimalFormat df = new DecimalFormat("$##0.00");
		String output = "\tAccount Number: " + acctNum.format(accountNumber) + "\n";
		output+= "\tOwner Name: " + ownerName + "\n";
		output+= "\tDuration: " + duration + "\n";
		output+= "\tStarting Amount: " + df.format(startingAmount) + "\n";
		return output;
	}
	
	public void outputCurrentValue(int months)
	{
		
			DecimalFormat df = new DecimalFormat("$##0.00");
			System.out.println(toString());
			System.out.println("Interest: " + determineInterest());
			System.out.println("Month " + months + " of " + duration);
			System.out.println("Balance " + df.format(determineBalance(months)) + "\n");
		
	}
	
	

}
