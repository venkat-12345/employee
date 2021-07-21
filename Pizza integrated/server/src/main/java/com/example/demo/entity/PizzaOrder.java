package com.example.demo.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="PizzaOrder")
public class PizzaOrder {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator="seq")
	@GenericGenerator(name = "seq", strategy="increment")
	private int bookingOrderId;
	private LocalDate orderDate;
	private String transactionMode;
	private int quantity;
	private String size;
	private double totalCost;
	
	@ManyToOne(cascade = CascadeType.MERGE,fetch=FetchType.EAGER)
    @JoinColumn(name = "pizza_id", referencedColumnName = "id")
	private Pizza pizza;
	
	@ManyToOne(cascade = CascadeType.MERGE,fetch=FetchType.EAGER)
	@JoinColumn(name ="order_id",referencedColumnName = "orderid")
	private Order order;
	
	@ManyToOne(cascade = CascadeType.MERGE,fetch=FetchType.EAGER)
    @JoinColumn(name = "coupan_id", referencedColumnName = "coupanid")
	private Coupan coupan;

	public int getBookingOrderId() {
		return bookingOrderId;
	}

	public void setBookingOrderId(int bookingOrderId) {
		this.bookingOrderId = bookingOrderId;
	}

	public LocalDate getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}

	public String getTransactionMode() {
		return transactionMode;
	}

	public void setTransactionMode(String transactionMode) {
		this.transactionMode = transactionMode;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public double getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}

	public Pizza getPizza() {
		return pizza;
	}

	public void setPizza(Pizza pizza) {
		this.pizza = pizza;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Coupan getCoupan() {
		return coupan;
	}

	public void setCoupan(Coupan coupan) {
		this.coupan = coupan;
	}

	public PizzaOrder(int bookingOrderId, LocalDate orderDate, String transactionMode, int quantity, String size,
			double totalCost, Pizza pizza, Order order, Coupan coupan) {
		super();
		this.bookingOrderId = bookingOrderId;
		this.orderDate = orderDate;
		this.transactionMode = transactionMode;
		this.quantity = quantity;
		this.size = size;
		this.totalCost = totalCost;
		this.pizza = pizza;
		this.order = order;
		this.coupan = coupan;
	}

	public PizzaOrder() {
		super();

	}


	
}
