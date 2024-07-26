package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.StudentModel;

public class StudentController {
	public List<StudentModel> studentList = new ArrayList<>();
	Scanner scanner = new Scanner(System.in);
	StudentModel s1;

	public void createStudent() {
		System.out.println("Creating a Student");
		StudentModel sobj = new StudentModel();
		System.out.println("enter the student details");
		System.out.println("Student Id");
		sobj.setId(scanner.nextInt());
		scanner.nextLine(); // Consume the newline character left in the buffer
		System.out.println("Student Name");
		sobj.setName(scanner.nextLine());
		System.out.println("Student Phone");
		sobj.setPhone(scanner.nextLine());
		studentList.add(sobj);
		// s1 = new StudentModel(1, "kishore", "8186906603");
	}

	public void readStudent() {
		try {
			for (StudentModel student : studentList) {
				System.out.println(student.toString());
			}
//		System.out.println("Getting the student details");
//		System.out.println(s1.getId());
//		System.out.println(s1.getName());
//		System.out.println(s1.getPhone());

		} catch (Exception e) {
			System.out.println("Student not found");
		}
	}

	public void updateStudent() {
		System.out.println("enter the student id to update");
		int id = scanner.nextInt();
		scanner.nextLine();
		for (StudentModel student : studentList) {
			if (student.getId() == id) {
				System.out.println("updating the student details");
				System.out.println("Enter new details");
				System.out.println("New Student Name");
				student.setName(scanner.nextLine());
				System.out.println("New Student Phone");
				student.setPhone(scanner.nextLine());
			} else {
				{
					System.out.println("Student not found");
				}
			}
		}
	}

	public void deleteStudent() {
		System.out.println("enter the student id to delete");
		int id = scanner.nextInt();
		scanner.nextLine();
		for (StudentModel student : studentList) {
			if (student.getId() == id) {
				int index = studentList.indexOf(student);
				studentList.remove(index);
				break;
			}
		}
	}
}
