package studentdatabaseapp;

import java.util.Scanner;

public class StudentDataBaseApp {

	public static void main(String[] args) {
		
		// Ask user how many students will be added to database
		Scanner in = new Scanner(System.in); // import java.util.Scanner;
		System.out.println("How many students do you want to add? ");
		int numOfStudents = in.nextInt();
		Student [] students = new Student[numOfStudents];
		
		// Create n number of students
		for (int n = 0; n < numOfStudents; n++) {
			students[n] = new Student();
			students[n].payTuition();
			System.out.println(students[n].showInfo());
		}
		
		in.close(); // after we're done with everything else
		
	}

}
