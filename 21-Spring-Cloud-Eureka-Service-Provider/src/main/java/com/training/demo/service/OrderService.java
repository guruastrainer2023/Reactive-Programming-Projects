package com.training.demo.service;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.training.demo.bean.Order;

import jakarta.annotation.PostConstruct;

@Service
public class OrderService {
	
	private List<Order> orderList;
	
	
	@PostConstruct
	public void init() {
		if(this.orderList==null)
			this.orderList=new LinkedList<>();
		
		this.orderList.add(new Order(5001, LocalDate.of(2022, 10, 15), 101, 2500.00));
		this.orderList.add(new Order(5002, LocalDate.of(2022, 10, 18), 102, 4500.00));
	}
	
	public List<Order> getAllOrders(){
		return this.orderList;
	}
	
	public Order getOrderById(int id) {
		Order order=new Order(id);
		int index=this.orderList.indexOf(order);
		if(index>=0) {
			return this.orderList.get(index);
		}
		return null;
	}
	
	public Order addOrder(Order order) {
		this.orderList.add(order);
		return order;
	}

}
