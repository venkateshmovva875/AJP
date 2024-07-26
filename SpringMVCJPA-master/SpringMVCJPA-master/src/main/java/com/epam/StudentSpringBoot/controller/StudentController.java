package com.epam.StudentSpringBoot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.epam.StudentSpringBoot.model.Student;
import com.epam.StudentSpringBoot.service.Service;

@Controller
public class StudentController {
	@Autowired
	Service service;

	@GetMapping("addStudentInfo")
	public ModelAndView addStudentInfo(Student student) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("viewinsert");
		modelAndView.addObject("student", service.createStudentProfile(student));
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

	@GetMapping("view")
	public String view() {
		return "view";
	}

	@GetMapping("studentinformation")
	public ModelAndView studentinformation(int rollNo) {
		Student student = service.getStudentById(rollNo);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("studentinfodisplay");
		modelAndView.addObject("student", student);
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
	
	@GetMapping("UpdateStudentDetails")
	public ModelAndView UpdateStudentDetails(int rollNo) {
		Student student = service.getStudentById(rollNo);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("editstudentdetails");
		modelAndView.addObject("student", student);
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
	
	

}