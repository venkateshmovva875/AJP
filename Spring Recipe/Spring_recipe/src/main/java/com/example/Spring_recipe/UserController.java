package com.example.Spring_recipe;


import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

    @Autowired
    UserRepository userRepository;

    @RequestMapping("/signup")
    public String signup(Model model, HttpSession session) {
        String username = (String) session.getAttribute("username");
        if (username != null) {
            return "redirect:/home";
        }
        model.addAttribute("user", new User()); // Add an empty User object to the model for form binding
        return "signup";
    }

    @PostMapping("/signup")
    public String signupSubmit(@ModelAttribute User user) {
        // Save the user to the database
        userRepository.save(user);
        // Redirect to a success page or another appropriate page
        return "redirect:/signup-success";
    }

    @RequestMapping("/signup-success")
    public String signupSuccess() {
        return "signup-success"; // Return the name of the success page
    }

    @RequestMapping("/login")
    public String login(HttpSession session) {
        String username = (String) session.getAttribute("username");
        if (username != null)
            return "redirect:/home";

        return "login";
    }

    @PostMapping("/login")
    public String loginSubmit(@ModelAttribute User user, HttpSession session) {
        // Check if the user exists in the database (you may need to implement this method in UserRepository)
        User existingUser = userRepository.findByUsername(user.getUsername());
        if (existingUser != null && existingUser.getPassword().equals(user.getPassword())) {
            // Set the username in the session
            session.setAttribute("username", user.getUsername());
            // Redirect to the home page or another appropriate page
            return "redirect:/home";
        } else {
            // If login fails, redirect back to the login page with an error message
            return "redirect:/login?error";
        }
    }

    @RequestMapping("/home")
    public String home(HttpSession session, Model model) {
        // Get the username from the session
        String username = (String) session.getAttribute("username");
        if (username != null) {
            // Add the username to the model to display in the home page
            model.addAttribute("username", username);
            return "home";
        } else {
            // If the username is not found in the session, redirect to the login page
            return "redirect:/login";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        // Invalidate the session to logout the user
        session.invalidate();
        // Redirect to the login page
        return "redirect:/login";
    }

}