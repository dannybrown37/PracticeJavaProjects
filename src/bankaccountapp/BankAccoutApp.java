package bankaccountapp;

import java.util.LinkedList;
import java.util.List;

public class BankAccoutApp {

	public static void main(String[] args) {
		
		// data structure to hold our accounts
		List<Account> accounts = new LinkedList<Account>();
		
		// CSV local location
		String file = (
				"C:\\users\\danny\\java\\eclipse-workspace\\javaprojects" + 
				"\\src\\bankaccountapp\\NewBankAccounts.csv"
		);
		
		// Read a CSV file and put data into array list
		List<String[]> newAccountHolders = utilities.CSV.read(file);
		
		// Then create new accounts based on the data
		for(String[] accountHolder : newAccountHolders) {
			String name = accountHolder[0];
			String ssn = accountHolder[1];
			String accountType = accountHolder[2];
			double initDeposit = Double.parseDouble(accountHolder[3]); 
			// parseDouble can get a double from a string
			if (accountType.equals("Savings")) {
				accounts.add(new Savings(name, ssn, initDeposit));
			} else if (accountType.equals("Checking")) {
				accounts.add(new Checking(name, ssn, initDeposit));
			} else {
				System.out.println("Error reading account type!");
			}
		}
		
		// to access a single element in a linked list, use get(), not [i]
		accounts.get(0).showInfo();
		
		// iterate through accounts data structure, showInfo() for each account
		for (Account acc : accounts) {
			acc.showInfo(); 
			// no need for get() method, iterating through each in for loop
		}
		
		// example of test
		accounts.get((int) Math.random() * 20).deposit(1000);
		

		/* // unit tests
		Checking check1 = new Checking("Brian Wilson", "321456789", 666);
		
		Savings save1 = new Savings("Mary Wilson", "852741963", 420);

		check1.showInfo();
		save1.showInfo();
		
		save1.deposit(1000);
		save1.withdraw(200);
		save1.transfer("checking", 500);
		
		save1.compoundInterest();
		check1.compoundInterest();
		*/
	}

}
