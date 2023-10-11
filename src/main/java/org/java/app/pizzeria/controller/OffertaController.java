package org.java.app.pizzeria.controller;


import java.util.Optional;

import org.java.app.pizzeria.pojo.Offerta;
import org.java.app.pizzeria.pojo.Pizza;
import org.java.app.pizzeria.repo.OffertaRepo;
import org.java.app.pizzeria.repo.PizzaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/offerte")
public class OffertaController {

	@Autowired
	private OffertaRepo offertaRepo;
	
	@Autowired
	private PizzaRepo pizzaRepo;
	
	@GetMapping("/create")
	public String create(@RequestParam("pizzaId") Integer pizzaId, Model model) {
		
		Optional<Pizza> optionalPizza = pizzaRepo.findById(pizzaId);
			
			Offerta offerta = new Offerta();
			offerta.setPizza(optionalPizza.get());
			model.addAttribute("offerta", offerta);
			
			return "offerta-create";
			
		}
	
	@PostMapping("/create")
	public String storeNewOfferta(@Valid @ModelAttribute("offerta") Offerta offerta, 
			BindingResult bindingResult) {
		
		if (bindingResult.hasErrors()) {
			
			System.out.println("ERRORE");
			return "offerta-create";
		}
		
		offertaRepo.save(offerta);
		return "redirect:/pizza/" + offerta.getPizza().getId();
		
	}
		
		
		
		
	
}
