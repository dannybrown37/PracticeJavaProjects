package studentdatabaseapp;

import java.util.Scanner;

public class Student {
	private String studentFirstName;
	private String studentLastName;
	private String gradeLevel = "";
	private String studentId;
	private String [] courses;
	private int tuitionBalance;
	private static int costOfCourse = 600; // static is true for the object itself, not just the instance
	private static int id = 1000; // starting value stays with the class
	
	// Constructor: name and ID
	public Student() {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter student first name: ");
		this.studentFirstName = in.nextLine();
		
		System.out.println("Enter student last name: ");
		this.studentLastName = in.nextLine();
		
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
		
		this.setId();
		
		System.out.println(this.studentFirstName + " " + this.studentLastName + ", " + this.gradeLevel + ", " + this.studentId);
		
		
	}
	
	// Generate the student ID
	private void setId() {
		id++; // increment static id for each new student created to ensure unique id for each student
		this.studentId = this.gradeLevel.charAt(0) + "" + id; 
		// adding the empty string casts the entire statement as a string despite id being an int
	}

	// Enroll student in any of courses
	
	// Calculate total tuition based on enrollment
	
	// Allow student to view balance and pay tuition
	
	// Show status of student: name, ID, courses enrolled, balance
	
	
}
