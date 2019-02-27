package bankaccountapp;

public class Savings extends Account {

	// List properties specific to a savings account
	private int safetyDepositBoxId;
	private int safetyDepositBoxKey;
	
	// Constructor to initialize savings account properties
	public Savings(String name, String ssn, double initialDeposit) {
		super(name, ssn, initialDeposit);
		this.accountNumber = "1" + this.accountNumber;
		this.setSafetyDepositBox();
	}
		
	// List any methods specific to savings account
	private void setSafetyDepositBox() {
		this.safetyDepositBoxId = (int) (Math.random() * Math.pow(10,  3));
		this.safetyDepositBoxKey = (int) (Math.random() * Math.pow(10,  4));
	}
	
	@Override
	public void setRate() {
		this.rate = getBaseRate() - .25;
	}
	
	public void showInfo() {
		super.showInfo();
		System.out.println(
				"Savings Account Features:" +
				"\n   Safety Deposit Box ID: " + this.safetyDepositBoxId +
				"\n   Safety Deposit Box Key: " + this.safetyDepositBoxKey +
				"\n"
		);

	}
	
	
}
