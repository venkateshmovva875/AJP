package com.epam.StudentSpringBoot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.epam.StudentSpringBoot.dao.StudentDaoImpl;
import com.epam.StudentSpringBoot.model.Student;
import com.epam.StudentSpringBoot.model.Profile;

@Component
public class Service {
	@Autowired
	StudentDaoImpl studentDaoImpl;

	public Student createStudentProfile(Student student) {
		// TODO Auto-generated method stub
		Student tempStudent = studentDaoImpl.createStudent(student);
		return tempStudent;
	}
	public Profile createProfile(Profile profile) {
		// TODO Auto-generated method stub
		Profile tempProfile = studentDaoImpl.createProfile(profile);
		return tempProfile;
	}
	
	public Student getStudentById(int sid) {
		// TODO Auto-generated method stub
		Student tempStudent = studentDaoImpl.getStudentByRollNo(sid);
		return tempStudent;
	}
	public Profile getProfileById(long id) {
		// TODO Auto-generated method stub
		Profile tempProfile = studentDaoImpl.getProfileById(id);
		return tempProfile;
	}
	public Profile getProfileByName(String profileName) {
		Profile tempProfile = studentDaoImpl.getProfileByName(profileName);
		return tempProfile;
	}
	
	public List<Student> getAllStudents() {
		// TODO Auto-generated method stub
		List<Student> students = studentDaoImpl.getAll();
		return students;
	}
	public List<Profile> getAllProfiles() {
		// TODO Auto-generated method stub
		List<Profile> profiles = studentDaoImpl.getAllProf();
		return profiles;
	}

	public void deleteStudent(int sid) {
		studentDaoImpl.deleteStd(sid);
	}
	public void deleteProfile(long id) {
		studentDaoImpl.deleteProf(id);
	}
	
	public void updateStudent(Student stu) {
		studentDaoImpl.updateStd(stu);

	}
	public void updateProfile(Profile p) {
		studentDaoImpl.updateProf(p);

	}
}