package com.br.recipe.entity;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.springframework.lang.Nullable;

@Entity
public class Ingredient {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne
	private Food ingredient;
	
	@OneToOne
	@Nullable
	private Food substituteIngredient;
	
	private Long recipeId;

	public Ingredient(Food ingredient, Food substituteIngredient, Long recipeId) {
		super();
		this.ingredient = ingredient;
		this.substituteIngredient = substituteIngredient;
		this.recipeId = recipeId;
	}

	public Long getRecipeId() {
		return recipeId;
	}

	public void setRecipeId(Long recipeId) {
		this.recipeId = recipeId;
	}
	
}
