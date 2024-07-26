package com.example.Spring_recipe;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;

@Controller
public class TestController {

//	@Autowired
//    UserService userService;
	
    @RequestMapping("/")
    public String home(HttpSession session ) {
    	String username = (String) session.getAttribute("username");
    	if(username==null) {
    		return "login";
    	}
        return "home";
    }
    @RequestMapping("/add_recipe")
    public String add_recipe(HttpSession session) {
    	String username = (String) session.getAttribute("username");
    	if(username==null) {
    		return "login";
    	}
        return "add_recipe";
    }
    @RequestMapping("/view")
    public String view(HttpSession session) {
    	String username = (String) session.getAttribute("username");
    	if(username==null) {
    		return "login";
    	}
        return "view";
    }
    @RequestMapping("/updateToDB")
    public String updateToDB(HttpSession session) {
    	String username = (String) session.getAttribute("username");
    	if(username==null) {
    		return "login";
    	}
        return "updateToDB";
    }
    @RequestMapping("/deleteToDB")
    public String deleteToDB(HttpSession session) {
    	String username = (String) session.getAttribute("username");
    	if(username==null) {
    		return "login";
    	}
        return "deleteToDB";
    }
}
