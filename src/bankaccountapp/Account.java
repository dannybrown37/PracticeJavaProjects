package bankaccountapp;

public abstract class Account implements IBaseRate { 
	// abstract means we can't create objects from Account class
	// We can however create objects that inherit from it
	// Using an interface of IBaseRate assuming we will get these from elsewhere

	// List common properties for checking and savings accounts
	private String name;
	private String ssn;
	private double balance;
	private static int index = 10000;
	
	// Can't use private because it won't be available in child classes
	protected String accountNumber;
	protected double rate;
	
	
	
	// Constructor to set base properties and initialize the account
	public Account(String name, String ssn, double initialDeposit) {
		this.name = name;
		this.ssn = ssn;
		this.balance = initialDeposit;
		
		// Set account number
		index++;
		this.accountNumber = setAccountNumber();
		
		setRate(); // this will call respective based on checking or savings
	}
	
	// List common methods
	private String setAccountNumber() {
		String lastTwoOfSsn = this.ssn.substring(ssn.length()-2, ssn.length());
		int uniqueId = index;
		// random number between 0 and 1, multiplied by 10 to the 3rd power
		int randomNumber = (int) (Math.random() * Math.pow(10, 3)); 
		return lastTwoOfSsn + uniqueId + randomNumber;
	}
	
	public void compoundInterest() {
		double accruedInterest = this.balance * (this.rate/100);
		this.balance += accruedInterest;
		System.out.println("Accured Interest: $" + accruedInterest);
		printBalance();
	}
	
	// Checking/Savings must implement the inherited abstract method setRate()
	public abstract void setRate(); 
	
	public void deposit(double amount) {
		this.balance += amount;
		System.out.println("Depositing $" + amount + " to account number " +
				this.accountNumber + "."
		);
		this.printBalance();
	}
	
	public void withdraw(double amount) {
		this.balance -= amount;
		System.out.println("Withdrawing $" + amount + 
				" from account number " + this.accountNumber + "."
		);
		this.printBalance();
	}
	
	public void transfer(String toWhere, double amount) {
		this.balance -= amount;
		System.out.println("Transfering $" + amount + " from account number " + 
				this.accountNumber + " to " + toWhere + "."
		);
		this.printBalance();
	}
	
	public void printBalance() {
		System.out.println("The balance of account number " + 
			this.accountNumber + " is now $" + this.balance
		);
	}
	
	public void showInfo() {
		System.out.println(
				"NAME: " + this.name +
				"\nAccount Number: " + this.accountNumber +
				"\nBalance: " + this.balance +
				"\nInterest Rate: " + this.rate
		);
	}
}
