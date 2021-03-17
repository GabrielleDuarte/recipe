package com.br.recipe.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

import com.br.recipe.entity.Food;
import com.br.recipe.repository.FoodRepository;
import com.br.recipe.service.FoodService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/food")
public class FoodController {


	private final FoodRepository foodRepository;
	private final FoodService foodService;
	
	public FoodController(FoodRepository foodRepository, FoodService foodService) {
		this.foodService = foodService;
		this.foodRepository = foodRepository;
	}

	@GetMapping(value = "/list")
	@ApiOperation(value = "List all foods")
	public List<Food> listAllFood() {
		return foodRepository.findAll();
	}

	@GetMapping(value = "/{id}")
	@ApiOperation(value = "Search a food by name")
	public Food searchFood(@PathVariable String name) throws Exception {
	 return foodRepository.findByName(name);
	}

	@PostMapping(value = "/register")
	@ApiOperation(value = "Register a new food")
	public void foodSave(@RequestParam String name) {
		Food food = new Food(name);
		foodRepository.save(food);
	}
	
	@PostMapping(value = "/atreciperegister")
	@ApiOperation(value = "Register a new food in case it doesn't exist at the register of a recipe, or just returns its id")
	public Long foodInclude(@RequestParam String name) {
		Food food = foodService.addFood(name);
		return food.getId();
	}
}
