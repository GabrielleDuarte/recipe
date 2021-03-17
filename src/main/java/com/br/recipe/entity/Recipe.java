package com.br.recipe.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

@Entity
public class Recipe {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, length = 80)
	private String name;
	
	@Column(nullable = true, length = 5)
	private int preparationTime; 
	
	@Column ( nullable = true, length = 80)
	private DifficultyLevel difficultyLevel;

	@OneToMany
	private List<Ingredient> ingredients;
	
	private String preparation;
	
	@Column ( nullable = true, length = 80)
	private String creatorName;
	
	public Recipe() {
		super();
	}


	public Recipe(String name, int preparationTime, DifficultyLevel difficultyLevel, List<Ingredient> ingredients,
			String preparation, String creatorName) {
		super();
		this.name = name;
		this.preparationTime = preparationTime;
		this.difficultyLevel = difficultyLevel;
		this.ingredients = ingredients;
		this.preparation = preparation;
		this.creatorName = creatorName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getpreparationTime() {
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
	
	
}
