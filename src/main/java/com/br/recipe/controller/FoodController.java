package com.br.recipe.controller;

import java.util.List;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

import com.br.recipe.entity.Food;
import com.br.recipe.repository.FoodRepository;

@RestController
@RequestMapping(value = "/food")
public class FoodController {


	private final FoodRepository foodRepository;
	
	public FoodController(FoodRepository foodRepository) {
		super();
		this.foodRepository = foodRepository;
	}

	@GetMapping(value = "/alimentos")
	public List<Food> listAllFood(Model model) {
		return foodRepository.findAll();
	}

	@GetMapping(value = "/alimento/{id}")
	public Food searchFood(@PathVariable Long id) throws Exception {
	 return foodRepository.findById(id).orElseThrow(() -> new Exception("Alimento não encontrado"));
	}

	@PostMapping(value = "/alimento/salvar")
	public void foodSave(@RequestBody Food food) {
		foodRepository.save(food);
	}
}
