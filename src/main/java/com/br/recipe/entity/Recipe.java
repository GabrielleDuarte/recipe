package com.br.recipe.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Recipe {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, length = 80)
	private String name;
	
	@Column(nullable = true)
	private float preparationTime; 
	
	@Column ( nullable = true)
	private DifficultyLevel difficultyLevel;

	@OneToMany
	private List<Ingredient> ingredients;
	
	@Column( nullable = false, length = 3000)
	private String preparation;
	
	@Column ( nullable = true, length = 300)
	private String creatorName;
	
	public Recipe() {
		super();
	}


	public Recipe(String name, int preparationTime, DifficultyLevel difficultyLevel,
			String preparation, String creatorName) {
		super();
		this.name = name;
		this.preparationTime = preparationTime;
		this.difficultyLevel = difficultyLevel;
		this.preparation = preparation;
		this.creatorName = creatorName;
	}
	
	

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getpreparationTime() {
		return preparationTime;
	}

	public void setpreparationTime(int preparationTime) {
		this.preparationTime = preparationTime;
	}

	public DifficultyLevel getDifficultyLevel() {
		return difficultyLevel;
	}

	public void setDifficultyLevel(DifficultyLevel difficultyLevel) {
		this.difficultyLevel = difficultyLevel;
	}

	public String getpreparation() {
		return preparation;
	}

	public void setpreparation(String preparation) {
		this.preparation = preparation;
	}


	public List<Ingredient> getIngredients() {
		return ingredients;
	}


	public void setIngredients(List<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}
	
	
	
}
