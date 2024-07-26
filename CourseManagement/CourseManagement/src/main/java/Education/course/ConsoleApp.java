package Education.course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.Set;

@Component
public class ConsoleApp implements CommandLineRunner {

    @Autowired
    private EducationalPlatformService platformService;

    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Add Course");
            System.out.println("2. View All Courses");
            System.out.println("3. Update Course");
            System.out.println("4. Delete Course");
            System.out.println("5. Enroll Student");
            System.out.println("6. View All Students");
            System.out.println("7.View specific Student details");
            System.out.println("8. Update Student");
            System.out.println("9. Delete Student");
            System.out.println("10. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addCourse(scanner);
                    break;
                case 2:
                    viewAllCourses();
                    break;
                case 3:
                    updateCourse(scanner);
                    break;
                case 4:
                    deleteCourse(scanner);
                    break;
                case 5:
                    enrollStudent(scanner);
                    break;
                case 6:
                    viewAllStudents();
                    break;
                case 7:
                	showStudentDetailsById(scanner);
                	break;
                case 8:
                	updateStudentDetails(scanner);
                    break;
                case 9:
                    deleteStudent(scanner);
                    break;
                case 10:
                    System.exit(0);
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    private void addCourse(Scanner scanner) {
        System.out.print("Enter course name: ");
        String name = scanner.next();
        System.out.print("Enter course duration (in weeks): ");
        int duration = scanner.nextInt();

        Course course = new Course();
        course.setName(name);
        course.setDuration(duration);

        platformService.addCourse(course);
        System.out.println("Course added successfully!");
    }

    private void viewAllCourses() {
        List<Course> courses = platformService.getAllCourses();
        if (courses.isEmpty()) {
            System.out.println("No courses available!");
        } else {
            for (Course course : courses) {
                System.out.println(course.getId() + ": " + course.getName() + " (Duration: " + course.getDuration() + " weeks)");
            }
        }
    }

    private void updateCourse(Scanner scanner) {
        System.out.print("Enter course ID to update: ");
        Long courseId = scanner.nextLong();
        System.out.print("Enter new course name: ");
        String name = scanner.next();
        System.out.print("Enter new course duration (in weeks): ");
        int duration = scanner.nextInt();

        Course updatedCourse = new Course();
        updatedCourse.setName(name);
        updatedCourse.setDuration(duration);

        platformService.updateCourse(courseId, updatedCourse);
        System.out.println("Course updated successfully!");
    }

    private void deleteCourse(Scanner scanner) {
        System.out.print("Enter course ID to delete: ");
        Long courseId = scanner.nextLong();

        platformService.deleteCourse(courseId);
        System.out.println("Course deleted successfully!");
    }

    private void enrollStudent(Scanner scanner) {
        System.out.print("Enter student name: ");
        String name = scanner.next();

        Student student = new Student();
        student.setName(name);

        System.out.println("Available Courses:");
        List<Course> courses = platformService.getAllCourses();
        for (Course course : courses) {
            System.out.println(course.getId() + ": " + course.getName() + " (Duration: " + course.getDuration() + " weeks)");
        }

        System.out.print("Enter course IDs separated by comma to enroll (e.g., 1,2): ");
        String[] courseIdsInput = scanner.next().split(",");
        Set<Long> enrolledCourseIds = student.getEnrolledCourseIds();
        for (String courseId : courseIdsInput) {
            enrolledCourseIds.add(Long.parseLong(courseId));
        }

        platformService.enrollStudent(student);
        System.out.println("Student enrolled successfully!");
    }

    private void viewAllStudents() {
        List<Student> students = platformService.getAllStudents();
        if (students.isEmpty()) {
            System.out.println("No students enrolled!");
        } else {
            for (Student student : students) {
                System.out.println(student.getId() + ": " + student.getName() + " (Enrolled Courses: " + student.getEnrolledCourseIds() + ")");
            }
        }
    }
    
    public void showStudentDetailsById(Scanner scanner) {
        // Scan student ID
        System.out.print("Enter student ID to view details: ");
        Long studentId = scanner.nextLong();

        // Call EducationalPlatformService to get student details
        Optional<Student> optionalStudent = platformService.getStudentById(studentId);
        if (optionalStudent.isPresent()) {
            Student student = optionalStudent.get();
            System.out.println("Student ID: " + student.getId());
            System.out.println("Name: " + student.getName());
            System.out.println("Enrolled Courses: " + student.getEnrolledCourseIds());
        } else {
            System.out.println("Student not found with ID: " + studentId);
        }
    }

    public Student updateStudentDetails(Scanner scanner) {
        // Scan student ID
        System.out.print("Enter student ID to update: ");
        Long studentId = scanner.nextLong();

        // Scan new student name
        System.out.print("Enter new student name: ");
        String newName = scanner.next();

        // Scan enrolled course IDs
        System.out.print("Enter enrolled course IDs separated by commas: ");
        String[] courseIdsInput = scanner.next().split(",");
        Set<Long> enrolledCourseIds = new HashSet<>();
        for (String courseId : courseIdsInput) {
            enrolledCourseIds.add(Long.parseLong(courseId.trim()));
        }

        // Call EducationalPlatformService to update student details
        Optional<Student> optionalStudent = platformService.getStudentById(studentId);
        if (optionalStudent.isPresent()) {
            return platformService.updateStudentDetails(studentId, newName, enrolledCourseIds);
        } else {
            throw new IllegalArgumentException("Student not found with ID: " + studentId);
        }
    }

    private void deleteStudent(Scanner scanner) {
        System.out.print("Enter student ID to delete: ");
        Long studentId = scanner.nextLong();

        platformService.deleteStudent(studentId);
        System.out.println("Student deleted successfully!");
    }
}
