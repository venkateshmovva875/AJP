package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.student;
import com.example.demo.service.studentservice;
@Controller
@RequestMapping("/students")
public class Studentcontroller {
	
    @Autowired
	private studentservice studentservice;
	
	@PostMapping("/addstudentinfo")
	public String addstu(@ModelAttribute("student") student student){
		studentservice.registeruser(student);
		return "success";
		
	}
	
	@GetMapping("/viewSStudents")
    public String viewStudents(Model model) {
        List<student> studentList = studentservice.getAllStudents();
        model.addAttribute("students", studentList);
        return "viewStudent";
    }
	
	 @PostMapping("/updatestudentinfo")
	 public String updateStudentInfo(@ModelAttribute("student") student student,Model model) {
	        studentservice.update(student);

	        List<student> studentList = studentservice.getAllStudents();
	        model.addAttribute("students", studentList);
	        return "viewStudent";
	    }

	    @PostMapping("/deleteuser")
	    public String deleteUser(@RequestParam String name,Model model) {
	        // Delete the user by name
	        studentservice.delete(name);
	        List<student> studentList = studentservice.getAllStudents();
	        model.addAttribute("students", studentList);
	        return "viewStudent";// replace with the actual view or URL
	    }
	
}