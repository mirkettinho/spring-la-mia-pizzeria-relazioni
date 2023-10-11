package org.java.app.pizzeria.controller;

import java.util.List;

import org.java.app.pizzeria.pojo.Pizza;
import org.java.app.pizzeria.serv.PizzaServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.validation.Valid;
import jakarta.validation.Valid;

@Controller
public class PizzaController {

	@Autowired
	private PizzaServ pizzaServ;
	
	@GetMapping("/")
	public String getIndex(@RequestParam(required = false) String searchInput,	Model model) {
		
///		List<Pizza> pizze = pizzaServ.findAll();
		
		List<Pizza> pizze = searchInput == null ? pizzaServ.findAll() : pizzaServ.findByName(searchInput);
		model.addAttribute("pizze", pizze);
		model.addAttribute("searchInput", searchInput);
		
		return "pizze";
	}
	
	@GetMapping("/pizza-details/{id}")
	public String getShow(@PathVariable int id, Model model) {
		
		Pizza pizza = pizzaServ.findById(id);
		model.addAttribute("pizza", pizza);
		
		return "pizza-show";
	}
	
	@GetMapping("/pizza/create")
	public String getCreate(Model model) {
		
		model.addAttribute("pizza", new Pizza());
		
		return "pizza-create";
	}
	
	@PostMapping("/pizza/create")
	public String storeNewPizza(
		@Valid @ModelAttribute Pizza pizza,
		BindingResult br,
		Model model
	) {
		System.out.println("pizza:\n " + pizza);
		
		
		pizzaServ.save(pizza);
		
		return "redirect:/";
	}
	
	@GetMapping("pizza/update/{id}")
	public String getUpdate(@PathVariable int id, Model model) {
		
		Pizza pizza = pizzaServ.findById(id);
		model.addAttribute("pizza", pizza);
		
		return "pizza-create";
	}
	
	@PostMapping("pizza/update/{id}")
	public String updatePizza(@Valid @ModelAttribute Pizza pizza,
			BindingResult bindingResult,
			Model model) {
		
			System.out.println("Modifica pizza\n" + pizza);
			
			
			return savePizza(pizza, bindingResult, model);
	}
	
	@PostMapping("pizza/delete/{id}")
	public String deletePizza(@PathVariable int id) {
		
			Pizza pizza = pizzaServ.findById(id);
			pizzaServ.deletePizza(pizza);
			
			return "redirect:/";
	}
	
	private String savePizza(Pizza pizza, BindingResult bindingResult, Model model) {
		
		pizzaServ.save(pizza);
		return "redirect:/";
		
	}
	
}
