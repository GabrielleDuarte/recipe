package com.br.recipe.controller;

import java.util.List;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

import com.br.recipe.entity.Food;
import com.br.recipe.repository.FoodRepository;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/apirecipe")
public class FoodController {


	private final FoodRepository foodRepository;
	
	public FoodController(FoodRepository foodRepository) {
		super();
		this.foodRepository = foodRepository;
	}

	@GetMapping(value = "/alimentos")
	@ApiOperation(value = "List all foods")
	public List<Food> listAllFood() {
		return foodRepository.findAll();
	}

	@GetMapping(value = "/{id}")
	@ApiOperation(value = "Search a food by id")
	public Food searchFood(@PathVariable Long id) throws Exception {
	 return foodRepository.findById(id).orElseThrow(() -> new Exception("Alimento não encontrado"));
	}

	@PostMapping(value = "/salvar")
	@ApiOperation(value = "Register a new food")
	public void foodSave(@RequestParam String name) {
		Food food = new Food(name);
		foodRepository.save(food);
	}
}
