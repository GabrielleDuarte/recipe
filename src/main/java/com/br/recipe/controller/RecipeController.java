package com.br.recipe.controller;

import java.util.List;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.recipe.entity.Food;
import com.br.recipe.entity.Recipe;
import com.br.recipe.entity.DTO.RecipeDTO;
import com.br.recipe.repository.IngredientRepository;
import com.br.recipe.repository.RecipeRepository;
import com.br.recipe.service.RecipeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/recipe")
@Api(value = "API REST Recipe Controller")
public class RecipeController {

	private final RecipeRepository recipeRepository;
	private final RecipeService recipeService;

	public RecipeController(RecipeRepository recipeRepository, RecipeService recipeService) {
		this.recipeService = recipeService;
		this.recipeRepository = recipeRepository;
	}

	@PostMapping(value = "/register")
	@ApiOperation(value = "Regist a new recipe")
	public void registerRecipe(Model model, @ModelAttribute RecipeDTO recipeDTO, @RequestBody List<String> foodsAndSubstitutesNames) {
		recipeService.addRecipe(recipeDTO, foodsAndSubstitutesNames);
	}

	@GetMapping(value = "/recipes")
	@ApiOperation(value = "List all the recipes")
	public List<Recipe> listRecipes() {
		return recipeRepository.findAll();
	}

	@GetMapping()
	@ApiOperation(value = "List one recipe by id")
	public Recipe listRecipe(@PathVariable Long id) throws Exception {
		return recipeRepository.findById(id).orElseThrow(() -> new Exception("Receita não encontrada"));
	}
}
