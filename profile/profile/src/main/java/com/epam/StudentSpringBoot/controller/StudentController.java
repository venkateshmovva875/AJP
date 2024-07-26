package com.epam.StudentSpringBoot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.epam.StudentSpringBoot.model.Student;
import com.epam.StudentSpringBoot.service.Service;
import com.epam.StudentSpringBoot.model.Profile;
@Controller
public class StudentController {
	@Autowired
	Service service;
	
	@GetMapping("view")
	public String view() {
		return "view";
	}
	
	@GetMapping("addStudentInfo")
	public ModelAndView addStudentInfo(Student student) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("viewinsert");
		modelAndView.addObject("student", service.createStudentProfile(student));
		return modelAndView;
	}
	
	@GetMapping("addProfileInfo")
	public ModelAndView addProfileInfo(Profile profile) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("viewinsertprofile");
		modelAndView.addObject("profile", service.createProfile(profile));
		return modelAndView;
	}

	@GetMapping("allstudentdetails")
	public ModelAndView allstudentdetails() {
		List<Student> list = service.getAllStudents();
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("AllStudentDetails");
		modelAndView.addObject("students", list);
		return modelAndView;
	}
	@GetMapping("allprofiledetails")
	public ModelAndView allprofiledetails() {
		List<Profile> list = service.getAllProfiles();
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("AllProfileDetails");
		modelAndView.addObject("profiles", list);
		return modelAndView;
	}
	

	@GetMapping("studentinformation")
	public ModelAndView studentinformation(int rollNo) {
		Student student = service.getStudentById(rollNo);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("studentinfodisplay");
		modelAndView.addObject("student", student);
		return modelAndView;
	}
	@GetMapping("profileinformation")
	public ModelAndView profileinformation(long id) {
		Profile profile = service.getProfileById(id);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("profileinfodisplay");
		modelAndView.addObject("profile", profile);
		return modelAndView;
	}
	
	
	@GetMapping("DeleteStudentDetails")
	public ModelAndView DeleteStudentDetails(int rollNo) {
		Student student = service.getStudentById(rollNo);
		service.deleteStudent(rollNo);
		List<Student> list = service.getAllStudents();
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("AllStudentDetails");
		modelAndView.addObject("students", list);
		return modelAndView;
	}
	
	@GetMapping("DeleteProfileDetails")
	public ModelAndView DeleteProfileDetails(long id) {
		Profile profile = service.getProfileById(id);
		service.deleteProfile(id);
		List<Profile> list = service.getAllProfiles();
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("AllProfileDetails");
		modelAndView.addObject("profiles", list);
		return modelAndView;
	}
	
	@GetMapping("UpdateStudentDetails")
	public ModelAndView UpdateStudentDetails(int rollNo) {
		Student student = service.getStudentById(rollNo);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("editstudentdetails");
		modelAndView.addObject("student", student);
		return modelAndView;
	}
	@GetMapping("UpdateProfileDetails")
	public ModelAndView UpdateProfileDetails(long id) {
		Profile profile = service.getProfileById(id);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("editprofiledetails");
		modelAndView.addObject("profile", profile);
		return modelAndView;
	}
	
	@GetMapping("updatestudentinfo")
	public ModelAndView updatestudentinfo(Student student) {
		service.updateStudent(student);
		List<Student> list = service.getAllStudents();
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("AllStudentDetails");
		modelAndView.addObject("students", list);
		return modelAndView;
	}
	@GetMapping("updateProfileInfo")
	public ModelAndView updateProfileInfo(Profile profile) {
		service.updateProfile(profile);
		List<Profile> list = service.getAllProfiles();
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("AllProfileDetails");
		modelAndView.addObject("profiles", list);
		return modelAndView;
	}
	

}