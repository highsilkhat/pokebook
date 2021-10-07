package com.codingdojo.pokebooks.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
	

}
