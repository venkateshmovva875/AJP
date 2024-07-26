package view;

import java.util.Scanner;

import controller.StudentController;

public class StudentView {
	public static void main(String[] args) {
		StudentController studentController = new StudentController();
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.println("\n1.Create\n2.Read\n3.Update\n4.Delete\n5.Exit");
			System.out.println("Enter you choice");
			int choice = scanner.nextInt();
			switch (choice) {
			case 1:
				studentController.createStudent();
				break;
			case 2:
				studentController.readStudent();
				break;
			case 3:
				studentController.updateStudent();
				break;
			case 4:
				studentController.deleteStudent();
				break;
			case 5:
				scanner.close();
				System.exit(1);
			}
		}
	}
}
