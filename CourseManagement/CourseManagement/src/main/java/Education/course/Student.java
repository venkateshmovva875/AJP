package Education.course;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ElementCollection(fetch = FetchType.EAGER) // Change here to eagerly fetch the collection
    @CollectionTable(name = "enrolled_courses", joinColumns = @JoinColumn(name = "student_id"))
    @Column(name = "course_id")
    private Set<Long> enrolledCourseIds = new HashSet<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Long> getEnrolledCourseIds() {
		return enrolledCourseIds;
	}

	public void setEnrolledCourseIds(Set<Long> enrolledCourseIds) {
		this.enrolledCourseIds = enrolledCourseIds;
	}
    
    
}
