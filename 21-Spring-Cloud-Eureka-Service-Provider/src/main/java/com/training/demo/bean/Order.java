package com.training.demo.bean;

import java.time.LocalDate;
import java.util.Objects;

public class Order {
	private int id;
	private LocalDate orderDate;
	private int customerId;
	private double orderAmount;
	public Order(int id, LocalDate orderDate, int customerId, double orderAmount) {
		super();
		this.id = id;
		this.orderDate = orderDate;
		this.customerId = customerId;
		this.orderAmount = orderAmount;
	}
	public Order() {
		super();
	}
	public Order(int id) {
		super();
		this.id = id;
	}
	public Order(int id, int customerId) {
		super();
		this.id = id;
		this.customerId = customerId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public LocalDate getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public double getOrderAmount() {
		return orderAmount;
	}
	public void setOrderAmount(double orderAmount) {
		this.orderAmount = orderAmount;
	}
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		return id == other.id;
	}
	@Override
	public String toString() {
		return "Order [id=" + id + ", orderDate=" + orderDate + ", customerId=" + customerId + ", orderAmount="
				+ orderAmount + "]";
	}
	
	

}
