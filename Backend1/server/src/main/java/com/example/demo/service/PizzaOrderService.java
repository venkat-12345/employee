package com.example.demo.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.PizzaOrder;
import com.example.demo.repository.PizzaOrderRepository;



@Service
public class PizzaOrderService {
	@Autowired
	private PizzaOrderRepository rep;

	
	public PizzaOrder  bookPizzaOrder(PizzaOrder order) {
		if(order.getOrderDate()==null) {
			order.setOrderDate(LocalDate.now());
		}
		return rep.save(order);
	}
	public PizzaOrder updatePizzaOrder(PizzaOrder order) {
		PizzaOrder k= rep.findById(order.getBookingOrderId()).orElse(order);
		k.setCoupan(order.getCoupan());
		k.setOrder(order.getOrder());
		k.setOrderDate(order.getOrderDate());
		k.setPizza(order.getPizza());
		k.setQuantity(order.getQuantity());
		k.setSize(order.getSize());
		k.setTotalCost(order.getTotalCost());
		k.setTransactionMode(order.getTransactionMode());
		return rep.save(k);
	}
	public PizzaOrder cancelPizzaOrder(int  id) {
		PizzaOrder k=rep.findById(id).orElse(null);
		
		rep.deleteById(id);
		return k;
	}
	public PizzaOrder viewPizzaOrder(int  id) {
		
		return rep.findById(id).orElse(null);
	}
	public List<PizzaOrder> viewOrderList(){
		return rep.findAll();
	}
	public List<PizzaOrder> viewOrderList(LocalDate date){
		List<PizzaOrder> l= rep.findAll();
		List<PizzaOrder> l1=new ArrayList<>();
		int s=l.size();
		for(var i=0;i<s;i++) {
			PizzaOrder k=l.get(i);
			if(date.compareTo(k.getOrderDate())==0) {
				l1.add(k);
				
			}
			
		}
		return l1;
	}


	public List<PizzaOrder> calculateTotal(){
		for(PizzaOrder i: rep.findAll()) {
			String size= i.getSize();
			double quantity=i.getQuantity();
			double price=(i.getPizza()).getPizzaCost();
			if(!size.equals("medium")) {
				if(size.equals("large")) {
					price+=30;
				}
				else if(size.equals("small")) {
					price-=30;
				}
			}
			i.setTotalCost(quantity*price);
			rep.save(i);
		}
		return rep.findAll();
	}

}
