package com.br.recipe.service;

import org.springframework.stereotype.Service;

import com.br.recipe.entity.Food;
import com.br.recipe.repository.FoodRepository;

@Service
public class FoodService {
	
	private final FoodRepository foodRepository;

	public FoodService(FoodRepository foodRepository) {
		super();
		this.foodRepository = foodRepository;
	}
	
	public Food addFood(String name) {
				
		if(foodRepository.findByName(name) == null) {
			Food food = new Food(name);
			foodRepository.save(food);
			return food;
		}
		else {
			Food food = foodRepository.findByName(name);
			return food;
		}
	}	
}
