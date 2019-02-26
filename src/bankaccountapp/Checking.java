package bankaccountapp;

public class Checking extends Account {

	// List properties specific to a checking account
	int debitCardNumber;
	int debitCardPin;
	
	// Constructor to initialize checking account properties
	public Checking(String name, String ssn, double initialDeposit) {
		super(name, ssn, initialDeposit);
		System.out.println("NEW CHECKING ACCOUNT CREATED\n");
		
		
	}
	
	// List any methods specific to checking account
	
}
