package com.training.bean.pack5;


import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Bill {
	private int id;
	private String customerName;
	private LocalDate billingDate;
	private List<BillItem> billItems;
	
	public Bill(String customerName, LocalDate billingDate) {
		super();
		this.customerName = customerName;
		this.billingDate = billingDate;
		this.billItems=new LinkedList<BillItem>();
	}

	public Bill() {
		super();
		this.billItems=new LinkedList<BillItem>();
	}
	
	
	
	public Bill(int id) {
		super();
		this.id = id;
	}

	public void addBillItem(BillItem billItem){
		this.billItems.add(billItem);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public LocalDate getBillingDate() {
		return billingDate;
	}

	public void setBillingDate(LocalDate billingDate) {
		this.billingDate = billingDate;
	}

	public List<BillItem> getBillItems() {
		return billItems;
	}

	public void setBillItems(List<BillItem> billItems) {
		this.billItems = billItems;
	}

	@Override
	public String toString() {
		return "\n Bill [id=" + id + ", customerName=" + customerName + ", billingDate=" + billingDate + ", billItems="
				+ billItems + "]";
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
		Bill other = (Bill) obj;
		return id == other.id;
	}
	
	
	
}
