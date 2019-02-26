package bankaccountapp;

public class Savings extends Account {

	// List properties specific to a savings account
	int safetyDepositBoxId;
	int safetyDepositBoxKey;
	
	// Constructor to initialize savings account properties
	public Savings(String name, String ssn, double initialDeposit) {
		super(name, ssn, initialDeposit);
		System.out.println("NEW SAVINGS ACCOUNT CREATED\n");
		
	}
		
	// List any methods specific to savings account
}
