package com.example.Spring_recipe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("com.example.Spring_recipe")
@EnableJpaRepositories("com.example.Spring_recipe")
public class SpringRecipeApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringRecipeApplication.class, args);
	}

}
