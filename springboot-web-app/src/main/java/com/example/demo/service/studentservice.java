package com.example.demo.service;

import java.util.List;
import com.example.demo.model.student;


public interface studentservice {
	
	public void registeruser(student student);

	public List<student> getAllStudents();
	
	public void update(student student);
	
	public void delete(String name);

}
