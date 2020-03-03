package com.br.recipe.service;

import java.util.List;

import com.br.recipe.entity.Food;

public interface FoodService {
	
	public List<Food> listAll();
	
	public Food findById(Long id);
	
	public void addFood(Food food);
	
	public void deleteFood(Long id);
	
	public void updateFood(Long id, Food foodNew);
}
