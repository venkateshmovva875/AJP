package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.user;
import com.example.demo.repository.Userrepository;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class Maincontroller {
	
	private final Userrepository userrepository;
	
	public Maincontroller(Userrepository userrepository)
	{
		this.userrepository=userrepository;
	}
	
	@RequestMapping("/")
	public String home()
	{
		return "home";
	}
	

    @RequestMapping("/addStudent")
    public String showAddStudentPage() {
        return "addStudent";
    }
	
	@PostMapping("/senddata")
	public String data(HttpServletRequest req)
	{
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		user user = userrepository.findById(username).orElse(null);
		if (user != null && user.getPassword().equals(password)) {
            // User exists and password is correct
            System.out.println("Login successful");
            return "index"; // replace "success" with the appropriate view name
        } else {
            // User does not exist or password is incorrect
            System.out.println("Login failed");
            return "failure";
            
        	}
	}
	@RequestMapping("/updateStudent")
    public String updateStudent() {
        return "updateStudent"; 
    }
	
	@RequestMapping("/deleteStudent")
    public String deleteStudent() {
        return "deleteStudent";
    }
	 
	
	
}
