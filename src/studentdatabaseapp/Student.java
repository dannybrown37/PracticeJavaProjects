package studentdatabaseapp;

import java.util.Scanner;
import java.util.*; // for List<String>

public class Student {
	private String studentFirstName;
	private String studentLastName;
	private String gradeLevel = "";
	private String studentId;
	private List<String> courses = new ArrayList<String>();
	private int tuitionBalance = 0;
	private static int costOfCourse = 600; // static is true for the object itself, not just the instance
	private static int id = 1000; // starting value stays with the class
	
	// Constructor: name and ID
	public Student() {
		Scanner in = new Scanner(System.in);
		// First name
		System.out.println("Enter student first name: ");
		this.studentFirstName = in.nextLine();
		
		// Last name
		System.out.println("Enter student last name: ");
		this.studentLastName = in.nextLine();
		
		// Grade level
		while (this.gradeLevel == "") {
			System.out.println("1. Freshman\n2. Sophomore\n3. Junior \n4. Senior\nEnter student class level: ");
			int choice = in.nextInt();
			if (choice == 1) {
				this.gradeLevel = "Freshman";
			} else if (choice == 2) {
				this.gradeLevel = "Sophomore";
			} else if (choice == 3) {
				this.gradeLevel = "Junior";
			} else if (choice == 4) {
				this.gradeLevel = "Senior";
			} else {
				System.out.println("!!! Please enter 1, 2, 3, or 4 !!!");
			}
		}
		
		// ID
		this.setId();
		
		// Enroll
		this.enroll();
		
	}
	
	// Generate the student ID
	private void setId() {
		id++; // increment static id for each new student created to ensure unique id for each student
		this.studentId = this.gradeLevel.charAt(0) + "" + id; 
		// adding the empty string casts the entire statement as a string despite id being an int
	}

	// Enroll student in any of courses and calculate tuition as we go
	public void enroll() {
		do {
			System.out.print("Enter course to enroll (Q to quit): ");
			Scanner in = new Scanner(System.in);
			String course = in.nextLine();
			if (!course.equals("Q".toLowerCase())) {
				this.courses.add(course);
				this.tuitionBalance += costOfCourse;
			}
			else {
				break;
			}
		} while (1 != 0);
		
	}
	
	// Allow student to view balance
	public void viewBalance() {
		System.out.println("Your balance is: $" + this.tuitionBalance);
	}
	
	// Allow student to pay tuition balance
	public void payTuition() {
		System.out.print("Enter the amount you are paying: $");
		Scanner in = new Scanner(System.in);
		int payment = in.nextInt();
		this.tuitionBalance -= payment;
		System.out.println("Thank you for your payment of $" + payment + ".");
		System.out.println("Your new tuition balance is: $" + this.tuitionBalance);
	}
	
	// Show status of student: name, ID, courses enrolled, balance
	public String showInfo() {
		return "Name: " + studentFirstName + " " + studentLastName +
				"\nGrade Level: " + gradeLevel +
				"\nStudent ID: " + studentId +
				"\nCourses Enrolled: " + courses +
				"\nBalance: $" + tuitionBalance;
	}
	
	
}
