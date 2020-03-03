package com.br.recipe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.recipe.dao.FoodDAO;
import com.br.recipe.entity.Food;

@Service
public class FoodServiceImpl implements FoodService {

	@Autowired
	private FoodDAO foodDAO;

	@Override
	public List<Food> listAll() {
		List<Food> foods = foodDAO.findAll();
		return foods;
	}

	@Override
	public Food findById(Long id) {
		Food food = foodDAO.findById(id).orElse(new Food());
		return food;
	}

	@Override
	public void addFood(Food food) {
		foodDAO.save(food);
	}

	@Override
	public void deleteFood(Long id) {
		foodDAO.deleteById(id);

	}

	@Override
	public void updateFood(Long id, Food foodNew) {
		Food food = foodDAO.findById(id).orElse(new Food());
		food.setNome(foodNew.getNome());
		foodDAO.save(food);
	}

}
