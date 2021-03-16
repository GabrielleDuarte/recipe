package com.br.recipe.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

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

	@Transient 
	private List<Ingredients> ingredients;
	
	private String description;
	
	public Recipe() {
		super();
	}

	public Recipe(String name, int runtime, DifficultyLevel difficultyLevel, List<Ingredients> ingredients,
			String description) {
		super();
		this.name = name;
		this.runtime = runtime;
		this.difficultyLevel = difficultyLevel;
		this.ingredients = ingredients;
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRuntime() {
		return runtime;
	}

	public void setRuntime(int runtime) {
		this.runtime = runtime;
	}

	public DifficultyLevel getDifficultyLevel() {
		return difficultyLevel;
	}

	public void setDifficultyLevel(DifficultyLevel difficultyLevel) {
		this.difficultyLevel = difficultyLevel;
	}

	public List<Ingredients> getIngredients() {
		return ingredients;
	}

	public void setIngredients(List<Ingredients> ingredients) {
		this.ingredients = ingredients;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
