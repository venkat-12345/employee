package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.PizzaDto;
import com.example.demo.entity.Pizza;
import com.example.demo.repository.PizzaRepo;
import com.example.demo.service.PizzaService;

@RestController
@RequestMapping("/pizza")
public class PizzaController {
	@Autowired
	private  PizzaService pizzaService;
	private  PizzaRepo pizzaRepo;
	

	@GetMapping("/viewpizzalist")
	public ResponseEntity<List<Pizza>>viewPizzaList1(){
		List<Pizza> pizza = pizzaService.viewPizzaList();
		return new ResponseEntity<>(pizza,HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<Pizza> addPizza(@RequestBody PizzaDto pizza){
		Pizza newPizza = pizzaService.addPizza(pizza.getPizza());
		return new ResponseEntity<>(newPizza,HttpStatus.CREATED);
	}
	
	@PutMapping("/update")
	public ResponseEntity<Pizza> updatePizza(@RequestBody PizzaDto pizza){
		pizzaService.updatePizza(pizza.getPizza());
		return new ResponseEntity<>(pizza.getPizza(),HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")	
	public ResponseEntity<String> deletePizza(@PathVariable("id") int id){	
		String msg=pizzaService.deletePizza(id);	
		return new ResponseEntity<>(msg,HttpStatus.OK);	
	}
	@GetMapping("/viewpizzalist/{query}")
	public ResponseEntity<List<Pizza>>viewPizzaList(@PathVariable("query") String name){
		List<Pizza> pizzas=pizzaService.viewPizzaList(name);
		return new ResponseEntity<>(pizzas,HttpStatus.OK);
	}
	
	@GetMapping("/viewpizza/{id}")
	public ResponseEntity<Pizza>viewPizza(@PathVariable("id") Long id){
		Pizza pizza=pizzaService.viewPizza(id);
		return new ResponseEntity<>(pizza,HttpStatus.OK);
	}
	
	@GetMapping(value="/viewpizza")
	public ResponseEntity<List<Pizza>>viewPizzaList(@RequestParam(value="id1")Double id1,@RequestParam(value="id2")Double id2){
		List<Pizza> pizza=pizzaService.viewPizzaList(id1,id2);
		return new ResponseEntity<>(pizza,HttpStatus.OK);
	}
	
	@GetMapping("/type/veg")
	public ResponseEntity<List<Pizza>>searchByVeg(){
		List<Pizza> veg=this.pizzaRepo.findByTypeStartingWith("veg");
		return new ResponseEntity<>(veg,HttpStatus.OK);
	}
	
	@GetMapping("/type/non-veg")
	public ResponseEntity<List<Pizza>> searchByNonveg(){
		List<Pizza> veg=this.pizzaRepo.findByTypeStartingWith("non");
		return new ResponseEntity<>(veg,HttpStatus.OK);
	}
	
	@GetMapping("/vieworder")
	public List<Pizza> findAllorders(){
		return pizzaRepo.findAll();
	}
	
	@PostMapping("/addpizzacoupons")
	public ResponseEntity<Pizza> addPizzaCoupons(@RequestBody PizzaDto pcoupon){
		Pizza newPcoupon = pizzaService.addPizzaCoupons(pcoupon.getPizza());
		return new ResponseEntity<>(newPcoupon,HttpStatus.CREATED);
	}
	
	@GetMapping("/viewpizzacoupons")
	public ResponseEntity<List<Pizza>> viewPizzaCoupons(){
		List<Pizza> pcoupons=pizzaService.viewPizzaCoupons();
		return new ResponseEntity<>(pcoupons,HttpStatus.OK);
	}
	
	@GetMapping(value="/pizzacostaftercoupon")
	public ResponseEntity<Float>pizzaCostAfterCoupon(@RequestParam(value="pid")Long pid,@RequestParam(value="cid")Integer cid){
		float cost=pizzaService.pizzaCostAfterCoupon(pid,cid);
		return new ResponseEntity<>(cost,HttpStatus.OK);
	}


	
	
	
}