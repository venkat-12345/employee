package com.example.demo.repository;


import org.springframework.data.jpa.repository.JpaRepository;


import com.example.demo.entity.PizzaOrder;

public interface PizzaOrderRepository extends JpaRepository<PizzaOrder, Integer>{






}
