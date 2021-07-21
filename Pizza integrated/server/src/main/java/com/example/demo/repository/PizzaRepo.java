package com.example.demo.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Pizza;



public interface PizzaRepo extends JpaRepository<Pizza,Integer>{

	
	
	public List<Pizza> findByNameContaining(String name);

	List<Pizza> findByTypeContaining(String type);

	List<Pizza> findByNameLike(String veggie);

	List<Pizza> findByNameStartingWith(String veggie);

	List<Pizza> findByTypeStartingWith(String string);

	List<Pizza> findByPriceBetween(Double minCost, Double maxCost);

	Pizza getById(Long id);

	


	
}