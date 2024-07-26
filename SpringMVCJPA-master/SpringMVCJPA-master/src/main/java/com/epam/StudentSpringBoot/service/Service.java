package com.epam.StudentSpringBoot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.epam.StudentSpringBoot.dao.StudentDaoImpl;
import com.epam.StudentSpringBoot.model.Student;

@Component
public class Service {
	@Autowired
	StudentDaoImpl studentDaoImpl;

	public Student createStudentProfile(Student student) {
		// TODO Auto-generated method stub
		Student tempStudent = studentDaoImpl.createStudent(student);
		return tempStudent;
	}

	public Student getStudentById(int sid) {
		// TODO Auto-generated method stub
		Student tempStudent = studentDaoImpl.getStudentByRollNo(sid);
		return tempStudent;
	}

	public List<Student> getAllStudents() {
		// TODO Auto-generated method stub
		List<Student> students = studentDaoImpl.getAll();
		return students;
	}

	public void deleteStudent(int sid) {
		studentDaoImpl.deleteStd(sid);
	}

	public void updateStudent(Student stu) {
		studentDaoImpl.updateStd(stu);

	}
}