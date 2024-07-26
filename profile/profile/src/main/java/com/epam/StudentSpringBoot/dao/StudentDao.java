package com.epam.StudentSpringBoot.dao;

import java.util.List;

import com.epam.StudentSpringBoot.model.*;

public interface StudentDao {
	
	public Student createStudent(Student s);
	public Profile createProfile(Profile p);
	
	public Student getStudentByRollNo(int sid);
	public Profile getProfileById(long id);
	public Profile getProfileByName(String profileName);
	
	public List<Student> getAll();
	public List<Profile> getAllProf();
	
	public void deleteStd(int sid);
	public void deleteProf(long id);
	
	public void updateStd(Student s);
	public void updateProf(Profile p);
}
