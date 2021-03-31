package com.br.recipe.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.recipe.entity.Ingredient;

public interface IngredientRepository extends JpaRepository<Ingredient, Long> {

}
