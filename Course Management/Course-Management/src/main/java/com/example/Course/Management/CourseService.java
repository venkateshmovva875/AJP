package com.example.Course.Management;

import org.springframework.beans.factory.annotation.Autowired; // Import Autowired annotation
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

@Service
public class CourseService {

    @Autowired
    private CourseManagement course;
    private Map<Integer, CourseManagement> courseDatabase = new HashMap<>();
    private Scanner scanner = new Scanner(System.in);

    public CourseManagement getCourse() {
        return course;
    }

    public void setCourse(CourseManagement course) {
        this.course = course;
    }

    public Map<Integer, CourseManagement> getCourseDatabase() {
        return courseDatabase;
    }

    public void setCourseDatabase(Map<Integer, CourseManagement> courseDatabase) {
        this.courseDatabase = courseDatabase;
    }

    public void addCourse(CourseManagement course) {
        courseDatabase.put(course.getId(), course);
    }

    public void updateCourse(CourseManagement updatedCourse) {
        courseDatabase.put(updatedCourse.getId(), updatedCourse);
    }

    public void deleteCourse(int courseId) {
        courseDatabase.remove(courseId);
    }

    public CourseManagement getCourse(int courseId) {
        return courseDatabase.get(courseId);
    }

    public void start() {
        boolean exit = false;
        while (!exit) {
            System.out.println("\nMenu:");
            System.out.println("1. Add Course");
            System.out.println("2. Read Courses");
            System.out.println("3. Get Course by ID");
            System.out.println("4. Update Course");
            System.out.println("5. Delete Course");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addCourseFromInput();
                    break;
                case 2:
                    displayAllCourses();
                    break;
                case 3:
                    getCourseById();
                    break;
                case 4:
                    updateCourseFromInput();
                    break;
                case 5:
                    deleteCourseFromInput();
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

    private void addCourseFromInput() {
        System.out.print("Enter course ID: ");
        int id = scanner.nextInt();
        System.out.print("Enter course name: ");
        String name = scanner.next();
        System.out.print("Enter course duration: ");
        String duration = scanner.next();

        CourseManagement newCourse = new CourseManagement();
        newCourse.setId(id);
        newCourse.setName(name);
		newCourse.setDuration(duration);
        addCourse(newCourse);
        System.out.println("Course added successfully.");
    }

    private void updateCourseFromInput() {
        System.out.print("Enter course ID to update: ");
        int id = scanner.nextInt();
        CourseManagement existingCourse = getCourse(id);
        if (existingCourse == null) {
            System.out.println("Course with ID " + id + " not found.");
            return;
        }

        System.out.print("Enter new course name: ");
        String newName = scanner.next();
        System.out.print("Enter new course description: ");
        String newDuration = scanner.next();

        existingCourse.setName(newName);
		existingCourse.setDuration(newDuration);
        updateCourse(existingCourse);
        System.out.println("Course updated successfully.");
    }

    private void deleteCourseFromInput() {
        System.out.print("Enter course ID to delete: ");
        int id = scanner.nextInt();
        deleteCourse(id);
        System.out.println("Course with ID " + id + " deleted successfully.");
    }

    private void getCourseById() {
        System.out.print("Enter course ID to retrieve: ");
        int id = scanner.nextInt();
        CourseManagement course = getCourse(id);
        if (course != null) {
            System.out.println("Course found:");
            System.out.println(course);
        } else {
            System.out.println("Course with ID " + id + " not found.");
        }
    }

    private void displayAllCourses() {
        System.out.println("All Courses:");
        courseDatabase.values().forEach(System.out::println);
    }
}
