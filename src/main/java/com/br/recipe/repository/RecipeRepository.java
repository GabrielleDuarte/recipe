package com.br.recipe.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.recipe.entity.Recipe;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {

}
