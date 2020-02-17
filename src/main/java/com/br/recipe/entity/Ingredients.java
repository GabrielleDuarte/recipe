package com.br.recipe.entity;


import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Ingredients {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne
	private Food ingredient;
	
	@OneToMany
	private List<Food> substituteIngredient;
	
	
	public Long getId() {
		return id;
	}
	

	public void setId(Long id) {
		this.id = id;
	}

	public Food getIngredient() {
		return ingredient;
	}

	public void setIngredient(Food ingredient) {
		this.ingredient = ingredient;
	}

	public List<Food> getSubstituteIngredient() {
		return substituteIngredient;
	}

	public void setSubstituteIngredient(List<Food> substituteIngredient) {
		this.substituteIngredient = substituteIngredient;
	}
	
	
}
