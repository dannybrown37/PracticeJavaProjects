package emailapp;

import java.util.Scanner;

public class Email {
	private String firstName;
	private String lastName;
	private String password;
	private String department;
	private String email;
	private int mailboxCapacity = 500; // default, but we can change with method below
	private int defaultPasswordLength = 11;
	private String alternateEmail;
	private String companySuffix = "codeco.com";
	
	// constructor to receive first name and last name
	public Email() {
		this.firstName = this.getFirstName();
		this.lastName = this.getLastName();
		
		// Call below method to ask for the department and return
		this.department = setDepartment();
		
		// Call below method that returns a random password
		this.password = generateRandomPassword(defaultPasswordLength);
		System.out.println("Your password is " + this.password);
		
		// Combine elements to generate email
		if (this.department != "") {
			email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + this.department.toLowerCase() + "." + companySuffix;
		}
		else {
			email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + companySuffix;
		}
	}
	// Get new user first name
	private String getFirstName() {
		Scanner in = new Scanner(System.in); // import java.util.Scanner; required
		System.out.println("Enter the new user's first name: ");
		return in.nextLine();
	}
	
	// Get new user last name
	private String getLastName() {
		Scanner in = new Scanner(System.in); // import java.util.Scanner; required
		System.out.println("Enter the new user's last name: ");
		return in.nextLine();
	}
	
	// Ask for department
	private String setDepartment() {
		System.out.println("Departments:\n1. Sales\n2. Development\n3. Accounting\n4. Admininstration\nEnter new user's department: ");
		Scanner in = new Scanner(System.in); // import java.util.Scanner; required
		int departmentChoice = in.nextInt();
		in.close(); // can't use in again, so only do this after last usage
		if (departmentChoice == 1) { return "Sales"; }
		else if (departmentChoice == 2) { return "Development"; }
		else if (departmentChoice == 3) { return "Accounting"; }
		else if (departmentChoice == 4) { return "Administration"; }
		else { return ""; }
	}
	
	// Generate a random password
	private String generateRandomPassword(int length) {
		String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()-_=+|";
		char[] password = new char[length];
		for (int i=0; i < length; i++) {
			int rand = (int) (Math.random() * passwordSet.length());
			password[i] = passwordSet.charAt(rand);
		}
		return new String(password);
	}
	
	// Set a mailbox capacity
	public void setMailboxCapacity(int capacity) {
		this.mailboxCapacity = capacity;
	}
	
	// Set the alternate email
	public void setAlternateEmail(String altEmail) {
		this.alternateEmail = altEmail;
	}
	
	// Change the password
	public void changePassword(String password) {
		this.password = password;
	}
	
	// GET METHODS
	public String getUserName() { return firstName + " " + lastName; }
	public int getMailboxCapacity() { return mailboxCapacity; }
	public String getAlternateEmail() { return alternateEmail; }
	
	public String showInfo() {
		return "DISPLAY NAME: " + firstName + " " + lastName +
				"\nCOMPANY EMAIL" + email + 
				"\nMAILBOX CAPACITY: " + mailboxCapacity + "mb";
	}
}
