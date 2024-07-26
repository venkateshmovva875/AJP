package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.student;
import com.example.demo.repository.Studentrepository;

@Service
public class studentserviceimpl implements studentservice {

	@Autowired
	private Studentrepository studentrepository;
	
	@Override
	public void registeruser(student student) {
		studentrepository.save(student);
		
	}

	@Override
	public List<student> getAllStudents() {
		// TODO Auto-generated method stub
		return studentrepository.findAll();
	}

	@Override
	public void update(student student) {
		// TODO Auto-generated method stub
		studentrepository.save(student);
	}

	@Override
	public void delete(String name) {
		// TODO Auto-generated method stub
		 studentrepository.deleteById(name); 
		
	}
	

}
