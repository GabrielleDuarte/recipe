package com.br.recipe.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.recipe.entity.Food;

public interface FoodRepository extends JpaRepository<Food, Long>{

}
