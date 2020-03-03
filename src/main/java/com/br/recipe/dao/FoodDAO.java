package com.br.recipe.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.recipe.entity.Food;

public interface FoodDAO extends JpaRepository<Food, Long>{

}
