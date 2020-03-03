package com.br.recipe.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.recipe.entity.Recipe;

public interface RecipeDAO extends JpaRepository<Recipe, Long> {

}
