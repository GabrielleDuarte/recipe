package com.br.recipe.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.recipe.entity.Recipe;
import com.br.recipe.repository.RecipeRepository;

import io.swagger.annotations.Api;

@RestController
@RequestMapping(value = "/recipe")
@Api(value = "API REST Recipe Controller")
public class RecipeController {
	
	private final RecipeRepository recipeRepository;
	
	public RecipeController(RecipeRepository recipeRepository) {
		super();
		this.recipeRepository = recipeRepository;
	}

	@PostMapping(value = "/register")
	public void registerRecipe(Recipe recipe) {
		recipeRepository.save(recipe);
	}
	
	@GetMapping(value = "/list")
	public List<Recipe> listRecipes() {
		return recipeRepository.findAll();
	}
}
