package com.example.Spring_recipe;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeRepository extends JpaRepository<Recipe, Integer>{
	
	 @Query(value = "SELECT * FROM recipe WHERE recipe_name = :recipeName", nativeQuery = true)
	    List<Recipe> findProductsBasedOnRatings(@Param("ratings") double ratings);

	List<Recipe> getRecipeByName(String recipeName);

}
