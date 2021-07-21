package com.example.demo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Coupan;
import com.example.demo.entity.Pizza;
import com.example.demo.repository.CoupanRepository;
import com.example.demo.repository.PizzaRepo;

@Service
@Transactional
public class PizzaService {
	private final PizzaRepo pizzaRepo;
	private final CoupanRepository couponRepo;
	@Autowired
	public PizzaService(PizzaRepo pizzaRepo,CoupanRepository couponRepo) {
		this.pizzaRepo = pizzaRepo;
		this.couponRepo=couponRepo;
	}
	
	
	public Pizza addPizza(Pizza pizza) {
		return pizzaRepo.save(pizza);
	}
	
	public List<Pizza> viewPizzaList(){
		return pizzaRepo.findAll();
	}
	
	public String deletePizza(int id) {
		pizzaRepo.deleteById(id);
		return "Pizza removed!";
	}
		
	public void updatePizza(Pizza pizza) {
		var newpizza=pizzaRepo.getById(pizza.getId());
		newpizza.setName( pizza.name);
		newpizza.setPrice( pizza.price);
		newpizza.setType( pizza.type);
		newpizza.setDescription(pizza.description);
		newpizza.setUrl( pizza.url);
		
	}
	
	public Pizza viewPizza(Long id){
		return pizzaRepo.getById(id);
	}
	
	public List<Pizza> viewPizzaList(String name){
		 return pizzaRepo.findByNameContaining(name);
	}
	
	public List<Pizza>viewPizzaList(Double minCost,Double maxCost){
		return pizzaRepo.findByPriceBetween(minCost,maxCost);
	}

	public Pizza addPizzaCoupons(Pizza pcoupon) {
		return pizzaRepo.save(pcoupon);
		
	}

	public List<Pizza> viewPizzaCoupons() {
		return pizzaRepo.findAll();
	}

	public float pizzaCostAfterCoupon(Long pid,Integer cid) {
		float finalcost=0;
	

		Pizza newpizza = pizzaRepo.getById(pid);
		Coupan pcoupon= couponRepo.getById(cid);
		Double price=newpizza.getPrice();			
		finalcost=(float)(price-(float)(price/100)*pcoupon.getCoupanType());
		return finalcost;
	}


	
	
}