package com.example.RecipeConsole2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

@Service
public class RecipeService {

    @Autowired
    private Recipe recipe;
    private Map<Integer, Recipe> recipeDatabase = new HashMap<>();
    private Scanner scanner = new Scanner(System.in);

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    public Map<Integer, Recipe> getRecipeDatabase() {
        return recipeDatabase;
    }

    public void setRecipeDatabase(Map<Integer, Recipe> recipeDatabase) {
        this.recipeDatabase = recipeDatabase;
    }

    public void addRecipe(Recipe recipe) {
        recipeDatabase.put(recipe.getId(), recipe);
    }

    public void updateRecipe(Recipe updatedRecipe) {
        recipeDatabase.put(updatedRecipe.getId(), updatedRecipe);
    }

    public void deleteRecipe(int recipeId) {
        recipeDatabase.remove(recipeId);
    }

    public Recipe getRecipe(int recipeId) {
        return recipeDatabase.get(recipeId);
    }

    public void start() {
        boolean exit = true;
        while(exit){
            System.out.println("\nMenu:");
            System.out.println("1. Add Recipe");
            System.out.println("2. Update Recipe Info");
            System.out.println("3. Delete Recipe");
            System.out.println("4. Get Recipe by ID");
            System.out.println("5. Display All Recipes");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addRecipeFromInput();
                    break;
                case 2:
                    updateRecipeFromInput();
                    break;
                case 3:
                    deleteRecipeFromInput();
                    break;
                case 4:
                    getRecipeById();
                    break;
                case 5:
                    displayAllRecipes();
                    break;
                case 6:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }

    private void addRecipeFromInput() {
        System.out.print("Enter recipe ID: ");
        int id = scanner.nextInt();
        System.out.print("Enter recipe name: ");
        String name = scanner.next();
        System.out.print("Enter recipe description: ");
        String description = scanner.next();

        Recipe newRecipe = new Recipe();
        newRecipe.setId(id);
        newRecipe.setName(name);
        newRecipe.setDescription(description);
        addRecipe(newRecipe);
        System.out.println("Recipe added successfully.");
    }

    private void updateRecipeFromInput() {
        System.out.print("Enter recipe ID to update: ");
        int id = scanner.nextInt();
        Recipe existingRecipe = getRecipe(id);
        if (existingRecipe == null) {
            System.out.println("Recipe with ID " + id + " not found.");
            return;
        }

        System.out.print("Enter new recipe name: ");
        String newName = scanner.next();
        System.out.print("Enter new recipe description: ");
        String newDescription = scanner.next();

        existingRecipe.setName(newName);
        existingRecipe.setDescription(newDescription);
        updateRecipe(existingRecipe);
        System.out.println("Recipe updated successfully.");
    }

    private void deleteRecipeFromInput() {
        System.out.print("Enter recipe ID to delete: ");
        int id = scanner.nextInt();
        deleteRecipe(id);
        System.out.println("Recipe with ID " + id + " deleted successfully.");
    }

    private void getRecipeById() {
        System.out.print("Enter recipe ID to retrieve: ");
        int id = scanner.nextInt();
        Recipe recipe = getRecipe(id);
        if (recipe != null) {
            System.out.println("Recipe found:");
            System.out.println(recipe);
        } else {
            System.out.println("Recipe with ID " + id + " not found.");
        }
    }

    private void displayAllRecipes() {
        System.out.println("All Recipes:");
        recipeDatabase.values().forEach(System.out::println);
    }

}
