package bankaccountapp;

public abstract class Account implements IBaseRate { // abstract means we can't create objects from Account class
													 // We can however create objects that inherit from it
													 // Using an interface of IBaseRate with the idea we will get these from elsewhere

	// List common properties for checking and savings accounts
	String name;
	String ssn;
	double balance;
	String accountNumber;
	double rate;
	
	
	
	// Constructor to set base properties and initialize the account
	public Account(String name, String ssn, double initialDeposit) {
		this.name = name;
		this.ssn = ssn;
		this.balance = initialDeposit;
		System.out.println("NAME: " + this.name + "\nSSN: " + this.ssn + "\nBalance: " + this.balance);
	}
	
	// List common methods
	
}
