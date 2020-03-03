package com.br.recipe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;

import com.br.recipe.entity.Food;
import com.br.recipe.service.FoodService;


@Controller
public class FoodController {
	
	private final String FOOD_INDEX = "/alimentos";
	
	@Autowired
	private FoodService foodService;
	
	@GetMapping(value = FOOD_INDEX)
	public String listAll(Model model){
		model.addAttribute("alimentos", foodService.listAll());
		model.addAttribute("alimento", new Food());
		return "foodlist";
	}

//	@PostMapping(value = "novoalimento")
//	public String addNewFood(@ModelAttribute Food food){
//		foodService.addFood(food);
//		return "redirect:" + FOOD_INDEX;
//	}
}
