package com.example.Spring_recipe;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;


@Controller
public class RecipeController {

    @Autowired
    RecipeService recipeService;

    @PostMapping("/addToDB")
    public String addToDB(Recipe recipe) {
    	System.out.println(recipe);
        recipeService.addRecipe(recipe);
        return "addSuccess";
    }
    @GetMapping("/view")
    public String view(Model model,HttpSession session) {
    	String username = (String) session.getAttribute("username");
    	if(username==null) {
    		return "login";
    	}
        List<Recipe> recipes = recipeService.getview();
        model.addAttribute("recipes", recipes);
        return "view";
    }
    @GetMapping("/update_recipe")
    public String updateToDB(Model model,HttpSession session) {
    	String username = (String) session.getAttribute("username");
    	if(username==null) {
    		return "login";
    	}
    	List<Recipe> recipes = recipeService.getview();
        model.addAttribute("recipes", recipes);
    	return "update_recipe";
    }
    @PostMapping("/updateToDB")
    public String updateToDB(Recipe recipe) {
    	recipeService.updateRecipe(recipe);
    	return "updateSuccess";
    }
    @GetMapping("/delete_recipe")
    public String deleteToDB(Model model,HttpSession session) {
    	String username = (String) session.getAttribute("username");
    	if(username==null) {
    		return "login";
    	}
    	List<Recipe> recipes = recipeService.getview();
        model.addAttribute("recipes", recipes);
    	return "delete_recipe";
    }
    @PostMapping("/deleteToDB")
    public String deleteToDB(Recipe recipe) {
    	recipeService.deleteRecipe(recipe);
        return "deleteSuccess";

    }
    
    @GetMapping("/SearchByName")
    public String SearchByName(Model model,HttpSession session) {
    	String username = (String) session.getAttribute("username");
    	if(username==null) {
    		return "login";
    	}
    	return "SearchByName";
    }
    @PostMapping("/SearchByName")
    public String SearchByName(@RequestParam("recipeName") String recipeName,Model model) {
    	List<Recipe> recipes = RecipeService.getRecipeByName(recipeName);
        model.addAttribute("recipes", recipes);
        return "SearchByName";

    }
}
