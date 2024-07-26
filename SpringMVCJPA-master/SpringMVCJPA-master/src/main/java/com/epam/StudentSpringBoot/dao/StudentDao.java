package com.epam.StudentSpringBoot.dao;

import java.util.List;

import com.epam.StudentSpringBoot.model.Student;

public interface StudentDao {
	
	public Student createStudent(Student s);
	
	public Student getStudentByRollNo(int sid);
	
	public List<Student> getAll();
	
	public void deleteStd(int sid);
	
	public void updateStd(Student s);

}
