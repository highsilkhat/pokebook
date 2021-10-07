package com.codingdojo.pokebooks.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.pokebooks.models.PokeBook;
import com.codingdojo.pokebooks.services.PokeBookService;

@Controller

public class PokeBooksController {
	
	@Autowired
	PokeBookService pokeBookService;
	
	@RequestMapping("/expenses")
	public String index (@ModelAttribute ("pokeBook") PokeBook pokeBook, Model model) {
		List<PokeBook> allPokeBooks = pokeBookService.allPokeBooks();
		
		model.addAttribute("pokeBooks", allPokeBooks);
		
		return "index.jsp";
	}
	
	@RequestMapping(value="/expenses/new", method=RequestMethod.POST)
	public String create (@Valid @ModelAttribute("pokeBook") PokeBook pokeBook, BindingResult result)
	{
		if(result.hasErrors()) {
			return "index.jsp";
		} else {
			pokeBookService.createBook(pokeBook);
			return "redirect:/expenses";
		}
	}
	
	@RequestMapping("/expenses/{id}/edit")
	public String edit(@PathVariable("id") Long id, Model model) 
	{
		PokeBook pokeBook = pokeBookService.findPokeBook(id);
		model.addAttribute("pokeBook", pokeBook);
		return "/pokebooks/edit.jsp";
	}
	
	@RequestMapping(value="/expenses/{id}", method=RequestMethod.PUT)
	public String update(@Valid @ModelAttribute("pokeBook") PokeBook pokeBook,
						BindingResult result,
						@PathVariable("id") Long id,
						@RequestParam(value="expense") String expense,
						@RequestParam(value="vendor") String vendor,
						@RequestParam(value="amount") double amount,
						@RequestParam(value="description") String description) 
	{
		if (result.hasErrors()) {
			return "/pokebooks/edit.jsp";
		} else {
			
			pokeBook = pokeBookService.updatePokeBook(id, expense, vendor, amount, description);
			return "redirect:/expenses";
		}
	}
	
	@RequestMapping("/expenses/{id}")
	public String show (Model model,
						@PathVariable(value="id") Long id) {
		PokeBook pokeBook = pokeBookService.findPokeBook(id);
		
		model.addAttribute("pokeBook", pokeBook);
		
		return "pokebooks/show.jsp";
	}
	
	@RequestMapping(value="expenses/{id}", method=RequestMethod.DELETE)
	public String destroy(@PathVariable("id") Long id) 
	{
		pokeBookService.deletePokeBook(id);
		return "redirect:/expenses";
	}
	

}

