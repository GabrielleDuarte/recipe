package com.br.recipe.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.recipe.entity.Recipe;
import com.br.recipe.repository.RecipeRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/apirecipe")
@Api(value = "API REST Recipe Controller")
public class RecipeController {
	
	private final RecipeRepository recipeRepository;
	
	public RecipeController(RecipeRepository recipeRepository) {
		super();
		this.recipeRepository = recipeRepository;
	}

	@PostMapping(value = "/register")
	@ApiOperation(value = "Regist a new recipe")
	public void registerRecipe(@RequestBody Recipe recipe) {
		recipeRepository.save(recipe);
	}
	
	@GetMapping(value = "/list")
	@ApiOperation(value = "List all the recipes")
	public List<Recipe> listRecipes() {
		return recipeRepository.findAll();
	}
}
