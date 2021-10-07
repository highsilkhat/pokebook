package com.codingdojo.pokebooks.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.pokebooks.models.PokeBook;
import com.codingdojo.pokebooks.repositories.PokeBookRepository;
	
	@Service
	public class PokeBookService {
		
		private final PokeBookRepository pokeBookRepository;
		
		public PokeBookService(PokeBookRepository pokeBookRepository) {
			this.pokeBookRepository = pokeBookRepository;
		}
		
		public List<PokeBook> allPokeBooks() {
			return pokeBookRepository.findAll()
;		}
		
		public PokeBook createBook(PokeBook pokeBook) {
			return pokeBookRepository.save(pokeBook);
		}
		
		public PokeBook findPokeBook(Long id) {
			Optional<PokeBook> optionalPokeBook = pokeBookRepository.findById(id);
			if (optionalPokeBook.isPresent()) {
				return optionalPokeBook.get();
			} else {
				return null;
			}
		}
		
		public PokeBook updatePokeBook(Long id, String expense, String vendor, double amount, String description) 
		{
			Optional<PokeBook> optionalPokeBook = pokeBookRepository.findById(id);
			if (optionalPokeBook.isPresent()) {
				PokeBook pokeBook = optionalPokeBook.get();
				
				pokeBook.setExpense(expense);
				pokeBook.setVendor(vendor);
				pokeBook.setAmount(amount);
				pokeBook.setDescription(description);
				
				return pokeBookRepository.save(pokeBook);
		} else {
			return null;
			}
		}
		
		public void deletePokeBook(Long id) {
			pokeBookRepository.deleteById(id);
		}
		
	}


