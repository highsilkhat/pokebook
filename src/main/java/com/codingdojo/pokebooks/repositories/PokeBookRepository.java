package com.codingdojo.pokebooks.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.codingdojo.pokebooks.models.PokeBook;

public interface PokeBookRepository extends CrudRepository<PokeBook, Long>{
	
	List<PokeBook> findAll();

}
