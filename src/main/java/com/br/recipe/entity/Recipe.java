package com.br.recipe.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Recipe {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, length = 80)
	private String name;
	
	@Column(nullable = true, length = 5)
	private int runtime; 
	
	@Column ( nullable = true, length = 80)
	private DifficultyLevel difficultyLevel;

	@OneToMany
	private List<Ingredients> ingredients;
	
	private String description;

	public Recipe(String name, int runtime, DifficultyLevel difficultyLevel, List<Ingredients> ingredients,
			String description) {
		super();
		this.name = name;
		this.runtime = runtime;
		this.difficultyLevel = difficultyLevel;
		this.ingredients = ingredients;
		this.description = description;
	}
}
