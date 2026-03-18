package com.training.ui;

import java.time.LocalDate;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.training.bean.pack5.Bill;
import com.training.bean.pack5.BillItem;
import com.training.util.HibernateUtil;

public class Main6 {
	
	static void insert(){
		Bill bill=new Bill("John David", LocalDate.now());
		
		BillItem item1=new BillItem(1, "Samsung Phone", 2, 24000.00);
		BillItem item2=new BillItem(2, "DELL Laptop", 1, 48000.00);
		BillItem item3=new BillItem(3, "iPhone", 2, 55000.00);
		
		bill.addBillItem(item1);
		bill.addBillItem(item2);
		bill.addBillItem(item3);
		
		
	}

	public static void main(String[] args) {
		insert();
		

	}

}
