package com.example.Course.Management;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

@Service
public class StudentService {

    @Autowired
    private StudentManagement student;
    private Map<Integer, StudentManagement> studentDatabase = new HashMap<>();
    private Scanner scanner = new Scanner(System.in);

    public StudentManagement getStudent() {
        return student;
    }

    public void setStudent(StudentManagement student) {
        this.student = student;
    }

    public Map<Integer, StudentManagement> getStudentDatabase() {
        return studentDatabase;
    }

    public void setStudentDatabase(Map<Integer, StudentManagement> studentDatabase) {
        this.studentDatabase = studentDatabase;
    }

    public void addStudent(StudentManagement student) {
        studentDatabase.put(student.getId(), student);
    }

    public void updateStudent(StudentManagement updatedStudent) {
        studentDatabase.put(updatedStudent.getId(), updatedStudent);
    }

    public void deleteStudent(int studentId) {
        studentDatabase.remove(studentId);
    }

    public StudentManagement getStudent(int studentId) {
        return studentDatabase.get(studentId);
    }

    public void start() {
        boolean exit = false;
        while (!exit) {
            System.out.println("\nMenu:");
            System.out.println("1. Add Student");
            System.out.println("2. Read Students");
            System.out.println("3. Get Student by ID");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addStudentFromInput();
                    break;
                case 2:
                    displayAllStudents();
                    break;
                case 3:
                    getStudentById();
                    break;
                case 4:
                    updateStudentFromInput();
                    break;
                case 5:
                    deleteStudentFromInput();
                    break;
                case 6:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
        scanner.close(); // Closing the scanner to release resources
    }

    private void addStudentFromInput() {
        System.out.print("Enter student ID: ");
        int id = scanner.nextInt();
        System.out.print("Enter student name: ");
        String name = scanner.next();

        // Take multiple course IDs as input
        List<Integer> courseIds = new ArrayList<>();
        System.out.print("Enter course IDs (comma-separated): ");
        String[] courseIdsStr = scanner.next().split(",");
        for (String courseId : courseIdsStr) {
            courseIds.add(Integer.parseInt(courseId.trim()));
        }

        StudentManagement newStudent = new StudentManagement();
        newStudent.setId(id);
        newStudent.setName(name);
        newStudent.setCourseIDs(courseIds);
        addStudent(newStudent);
        System.out.println("Student added successfully.");
    }

    private void updateStudentFromInput() {
        System.out.print("Enter student ID to update: ");
        int id = scanner.nextInt();
        StudentManagement existingStudent = getStudent(id);
        if (existingStudent == null) {
            System.out.println("Student with ID " + id + " not found.");
            return;
        }

        System.out.print("Enter new student name: ");
        String newName = scanner.next();

        // Update course IDs
        List<Integer> courseIds = existingStudent.getCourseIDs();
        System.out.print("Enter new course IDs (comma-separated): ");
        String[] courseIdsStr = scanner.next().split(",");
        courseIds.clear();
        for (String courseId : courseIdsStr) {
            courseIds.add(Integer.parseInt(courseId.trim()));
        }

        existingStudent.setName(newName);
        existingStudent.setCourseIDs(courseIds);
        updateStudent(existingStudent);
        System.out.println("Student updated successfully.");
    }

    private void deleteStudentFromInput() {
        System.out.print("Enter student ID to delete: ");
        int id = scanner.nextInt();
        deleteStudent(id);
        System.out.println("Student with ID " + id + " deleted successfully.");
    }

    private void getStudentById() {
        System.out.print("Enter student ID to retrieve: ");
        int id = scanner.nextInt();
        StudentManagement student = getStudent(id);
        if (student != null) {
            System.out.println("Student found:");
            System.out.println(student);
        } else {
            System.out.println("Student with ID " + id + " not found.");
        }
    }

    private void displayAllStudents() {
        System.out.println("All Students:");
        studentDatabase.values().forEach(System.out::println);
    }
}
