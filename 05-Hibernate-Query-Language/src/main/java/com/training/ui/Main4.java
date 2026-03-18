package com.training.ui;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.training.util.HibernateUtil;

public class Main4 {
	
	static void aggregate1() {
		String str="select sum(fees) from Doctor";
		
		HibernateUtil.init();
		Session session=HibernateUtil.getSession();
		
		Query<Double> query=session.createQuery(str);
		Double totalFees=query.getSingleResult();
		
		System.out.println("TOTAL FEES : "+ totalFees);
		
		HibernateUtil.cleanUp();
	}
	
	static void aggregate2() {
	
	}
	
	
	
	static void aggregate3() {
		
	}
	

	public static void main(String[] args) {
		aggregate1();

	}

}
