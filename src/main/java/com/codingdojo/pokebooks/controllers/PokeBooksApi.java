package com.codingdojo.pokebooks.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codingdojo.pokebooks.models.PokeBook;
import com.codingdojo.pokebooks.services.PokeBookService;

@RestController

public class PokeBooksApi {
	
	@Autowired
	PokeBookService pokeBookService;
	
	@RequestMapping("/api/pokebooks")
	public List<PokeBook> index() {
		return pokeBookService.allPokeBooks();
	}
	
	@RequestMapping(value="/api/pokebooks", method=RequestMethod.POST)
	public PokeBook create (
							@RequestParam(value="expense") String expense,
							@RequestParam(value="vendor") String vendor,
							@RequestParam(value="amount") double amount,
							@RequestParam(value="description") String description
							
			)
	{
		PokeBook pokeBook = new PokeBook(expense, vendor, amount, description);
		return pokeBookService.createBook(pokeBook);
	}
	
	@RequestMapping(value="/api/pokebooks/{id}")
	public PokeBook show(@PathVariable("id") Long id) {
		PokeBook pokeBook = pokeBookService.findPokeBook(id);
		return pokeBook;
	}
	
	@RequestMapping(value="/api/pokebooks/{id}", method=RequestMethod.PUT)
	public PokeBook update (
							@PathVariable("id") Long id,
							@RequestParam(value="expense") String expense,
							@RequestParam(value="vendor") String vendor,
							@RequestParam(value="amount") double amount,
							@RequestParam(value="description") String description
			)
	{
		PokeBook pokeBook = pokeBookService.updatePokeBook(id, expense, vendor, amount, description);
		return pokeBook;
	}
	
	@RequestMapping(value="/api/pokebooks/{id}", method = RequestMethod.DELETE)
	public void destroy(@PathVariable("id") Long id) 
	{
		pokeBookService.deletePokeBook(id);
	}

}
