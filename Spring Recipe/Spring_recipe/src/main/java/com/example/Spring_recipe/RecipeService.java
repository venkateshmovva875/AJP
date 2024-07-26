package com.example.Spring_recipe;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecipeService {

    @Autowired
    RecipeRepository recipeRepository;

    public Recipe addRecipe(Recipe recipe) {
        return recipeRepository.save(recipe);
    }

	public  List<Recipe> getview() {
		// TODO Auto-generated method stub
		
		return recipeRepository.findAll();
	}
	public Recipe updateRecipe(Recipe recipe) {
        return recipeRepository.save(recipe);
    }
	public void deleteRecipe(Recipe recipe) {
         recipeRepository.delete(recipe);
    }

	public List<Recipe> getRecipeByName(String recipeName) {
		
		// TODO Auto-generated method stub
		return recipeRepository.getRecipeByName(recipeName);
	}




}