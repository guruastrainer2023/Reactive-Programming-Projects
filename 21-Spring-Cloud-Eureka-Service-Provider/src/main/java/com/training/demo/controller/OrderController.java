package com.training.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.demo.bean.Order;
import com.training.demo.service.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	@GetMapping("/findAll")
	public ResponseEntity<List<Order>> findAllOrders(){
		List<Order> allOrders=this.orderService.getAllOrders();
		return ResponseEntity.ok(allOrders);
	}
	
	@GetMapping("/findById/{num}")
	public ResponseEntity<Order> findOrderById(@PathVariable(name="num") int id){
		Order order=this.orderService.getOrderById(id);
		return ResponseEntity.ok(order);
	}
	
	@PostMapping("/addOrder")
	public ResponseEntity<Order> addOrder(@RequestBody Order order) {
		Order order1=this.orderService.addOrder(order);
		return ResponseEntity.ok(order1);
	}

}
