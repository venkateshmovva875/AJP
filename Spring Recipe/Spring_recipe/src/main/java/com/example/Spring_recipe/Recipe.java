package com.example.Spring_recipe;


import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Component
@Entity
public class Recipe {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String recipe_name;
	private String ingredients;
	private String steps;
	private String cooking_time;
	private int Serving_size;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRecipe_name() {
		return recipe_name;
	}
	public void setRecipe_name(String recipe_name) {
		this.recipe_name = recipe_name;
	}
	public String getIngredients() {
		return ingredients;
	}
	public void setIngredients(String ingredients) {
		this.ingredients = ingredients;
	}
	public String getSteps() {
		return steps;
	}
	public void setSteps(String steps) {
		this.steps = steps;
	}
	public String getCooking_time() {
		return cooking_time;
	}
	public void setCooking_time(String cooking_time) {
		this.cooking_time = cooking_time;
	}
	public int getServing_size() {
		return Serving_size;
	}
	public void setServing_size(int Serving_size) {
		this.Serving_size = Serving_size;
	}
	@Override
	public String toString() {
		return "Recipe [id=" + id + ", recipe_name=" + recipe_name + ", ingredients=" + ingredients + ", steps=" + steps
				+ ", cooking_time=" + cooking_time + ", Serving_size=" + Serving_size + "]";
	}
	
	
}
