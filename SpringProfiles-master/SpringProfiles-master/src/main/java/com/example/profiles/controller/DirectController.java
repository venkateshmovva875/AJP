package com.example.profiles.controller;

import com.example.profiles.models.User;
import com.example.profiles.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Objects;

@Controller
public class DirectController {
    @Autowired
    UserService userService;
    @RequestMapping("/home")
    public String home() {
        return "home";
    }

    @GetMapping("/new")
    public String newUser(){
        return "newUser";
    }
    @GetMapping("/error")
    public String error(){
        return "error";
    }
    @GetMapping("/edit/{id}/")
    public String editUser(@PathVariable("id") Long id, Model model){
        User user = userService.getUserById(id);
        if (user != null) {
            model.addAttribute("user", user);
        }
        return "updateUser";
    }
    @GetMapping("/update")
    public String updateUser(){
        return "updateUser";
    }

    @PostMapping("/edit/{id}/update")
    public String updateUser(@PathVariable("id") Long id, User user, RedirectAttributes redirectAttributes) {
        User existingUser = userService.getUserById(id);
        System.out.println("User: " + id +user.getId()+user.getName());
        if (existingUser != null) {
            user.setId(id);
            User updatedUser = null;
            if (user.getPassword().equals(existingUser.getPassword())) {
                updatedUser = userService.updateUser(user);
            }

            if (updatedUser != null) {
                redirectAttributes.addFlashAttribute("message", "User updated successfully!");
            } else {
                redirectAttributes.addFlashAttribute("error", "Error updating user!");
            }
        } else {
            redirectAttributes.addFlashAttribute("error", "User not found!");
        }
        return "redirect:/users";
    }

@GetMapping("/delete/{id}/")
    public String deleteUser(@PathVariable("id") Long id, Model model) {
        return "delete";
    }

    @PostMapping("/delete/{id}/confirm")
    public String deleteUser(@PathVariable("id") Long id,User userForm, RedirectAttributes redirectAttributes) {
        User user = userService.getUserById(id);
        if (user != null && Objects.equals(user.getPassword(), userForm.getPassword())) {
            userService.deleteUser(id);
            redirectAttributes.addFlashAttribute("message", "User deleted successfully!");
        } else {
            redirectAttributes.addFlashAttribute("error", "User not found!");
        }
        return "redirect:/users";
    }
}
