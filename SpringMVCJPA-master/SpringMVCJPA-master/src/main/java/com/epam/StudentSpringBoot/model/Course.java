package com.epam.StudentSpringBoot.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Component
@Entity
public class Course {
	String coursename;
	@Id
	int courseid;

	public String getCoursename() {
		return coursename;
	}

	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}

	public int getCourseid() {
		return courseid;
	}

	public void setCourseid(int courseid) {
		this.courseid = courseid;
	}

	@Override
	public String toString() {
		return "Course [coursename=" + coursename + ", courseid=" + courseid + "]";
	}

}
