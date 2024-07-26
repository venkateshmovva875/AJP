package com.epam.StudentSpringBoot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.epam.StudentSpringBoot.service.Service;

@Controller
public class TestController 
{	
	@Autowired
	Service studentDaoImpl;
	
	@RequestMapping("/")
	public String Load() {
		return "view";
	}
	
	@RequestMapping("addStudent")
	public String addStudentDetails() {
		return "addStudent";
	}
	@RequestMapping("addProfile")
	public String addProfileDetails() {
		return "addProfile";
	}
	
	@RequestMapping("AllStudentDetails")
	public String AllStudentDetails() {
		return "AllStudentDetails";
	}
	@RequestMapping("AllProfileDetails")
	public String AllProfileDetails() {
		return "AllProfileDetails";
	}
	
	@RequestMapping("StudentInformation")
	public String StudentInformation() {
		return "StudentInformation";
	}
	@RequestMapping("ProfileInformation")
	public String ProfileInformation() {
		return "ProfileInformation";
	}
	
	@RequestMapping("DeleteStudent")
	public String DeleteStudent() {
		return "DeleteStudent";
	}
	@RequestMapping("DeleteProfile")
	public String DeleteProfile() {
		return "DeleteProfile";
	}
	
	@RequestMapping("UpdateStudent")
	public String UpdateStudent() {
		return "UpdateStudent";
	}
	
	@RequestMapping("UpdateProfile")
	public String UpdateProfile() {
		return "UpdateProfile";
	}
	
	
}