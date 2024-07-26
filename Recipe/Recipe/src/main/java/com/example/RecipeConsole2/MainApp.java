package com.example.RecipeConsole2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.example")
public class MainApp {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainApp.class);
        RecipeService recipeService = (RecipeService)context.getBean("recipeService");
        recipeService.start();
    }

}
