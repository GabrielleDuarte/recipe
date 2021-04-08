package com.br.recipe.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.br.recipe.entity.Food;
import com.br.recipe.entity.Ingredient;
import com.br.recipe.entity.Recipe;
import com.br.recipe.entity.DTO.RecipeDTO;
import com.br.recipe.repository.FoodRepository;
import com.br.recipe.repository.IngredientRepository;
import com.br.recipe.repository.RecipeRepository;

@Service
public class RecipeService {

	private final RecipeRepository recipeRepository;
	private final IngredientRepository ingredientRepository;
	private final FoodRepository foodRepository;
	private final FoodService foodService;

	public RecipeService(RecipeRepository recipeRepository, IngredientRepository ingredientRepository,
			FoodRepository foodRepository, FoodService foodService) {
		this.foodService = foodService;
		this.foodRepository = foodRepository;
		this.ingredientRepository = ingredientRepository;
		this.recipeRepository = recipeRepository;
	}

	public void addRecipe(RecipeDTO recipeDTO, List<String> foodsAndSubstitutesNames) {
		List<Ingredient> ingredients = new ArrayList<Ingredient>();

		Recipe recipe = new Recipe(recipeDTO.getName(), recipeDTO.getPreparationTime(), recipeDTO.getDifficultyLevel(),
				recipeDTO.getPreparation(), recipeDTO.getCreatorName());

		for (int i = 0; i < foodsAndSubstitutesNames.size(); i += 2) {
			Ingredient ingredient = new Ingredient(foodService.addFood(foodsAndSubstitutesNames.get(i)),
					foodService.addFood(foodsAndSubstitutesNames.get(i + 1)), recipe.getId());
			ingredientRepository.save(ingredient);
			ingredients.add(ingredient);
		}

		recipe.setIngredients(ingredients);
		recipeRepository.save(recipe);
	}

}
