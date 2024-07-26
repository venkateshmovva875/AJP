package Education.course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class EducationalPlatformService {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private StudentRepository studentRepository;

    // Course management operations
    public Course addCourse(Course course) {
        return courseRepository.save(course);
    }

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public Optional<Course> getCourseById(Long courseId) {
        return courseRepository.findById(courseId);
    }

    public Course updateCourse(Long courseId, Course updatedCourse) {
        Optional<Course> optionalCourse = courseRepository.findById(courseId);
        if (optionalCourse.isPresent()) {
            Course existingCourse = optionalCourse.get();
            existingCourse.setName(updatedCourse.getName());
            existingCourse.setDuration(updatedCourse.getDuration());
            return courseRepository.save(existingCourse);
        } else {
            throw new IllegalArgumentException("Course not found with id: " + courseId);
        }
    }

    public void deleteCourse(Long courseId) {
        courseRepository.deleteById(courseId);
    }

    // Student enrollment management operations
    public Student enrollStudent(Student student) {
        return studentRepository.save(student);
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

 // Method to get student by ID
    public Optional<Student> getStudentById(Long studentId) {
        return studentRepository.findById(studentId);
    }
    
    public Student updateStudentName(Long studentId, String newName) {
        Optional<Student> optionalStudent = studentRepository.findById(studentId);
        if (optionalStudent.isPresent()) {
            Student student = optionalStudent.get();
            student.setName(newName);
            return studentRepository.save(student);
        } else {
            throw new IllegalArgumentException("Student not found with ID: " + studentId);
        }
    }

    // Method to update student details (name and enrolled courses)
    @Transactional
    public Student updateStudentDetails(Long studentId, String newName, Set<Long> enrolledCourseIds) {
        Optional<Student> optionalStudent = studentRepository.findById(studentId);
        if (optionalStudent.isPresent()) {
            Student student = optionalStudent.get();
            student.setName(newName);
            student.setEnrolledCourseIds(enrolledCourseIds);
            return studentRepository.save(student);
        } else {
            throw new IllegalArgumentException("Student not found with ID: " + studentId);
        }
    }

    public void deleteStudent(Long studentId) {
        studentRepository.deleteById(studentId);
    }
}
