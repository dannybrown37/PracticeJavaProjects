package bankaccountapp;

public class Checking extends Account {

	// List properties specific to a checking account
	private long debitCardNumber;
	private int debitCardPin;
	
	// Constructor to initialize checking account properties
	public Checking(String name, String ssn, double initialDeposit) {
		super(name, ssn, initialDeposit);
		this.accountNumber = "2" + this.accountNumber;
		setDebitCard();
	}
	
	// List any methods specific to checking account
	private void setDebitCard() {
		this.debitCardNumber = (long) (Math.random() * Math.pow(10,  12));
		this.debitCardPin = (int) (Math.random() * Math.pow(10,  4));
	}
	
	@Override
	public void setRate() {
		this.rate = getBaseRate() * .15; // this.rate is inherited from Account class
	}
	
	public void showInfo() {
		super.showInfo();
		System.out.println(
				"Savings Account Features:" +
				"\n   Debit Card Number: " + this.debitCardNumber +
				"\n   Debit Card PIN: " + this.debitCardPin +
				"\n"
		);
	}
	
}
