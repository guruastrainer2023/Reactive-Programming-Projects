package com.training.ui;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.training.bean.pack3.State;
import com.training.util.HibernateUtil;

public class Main5 {

	
	static void insert(){
		State state1=new State("Andhra");
		state1.addCityName("Hyderabad");
		state1.addCityName("Nellore");
		
		State state2=new State("TamilNadu");
		state2.addCityName("Chennai");
		state2.addCityName("Coimbtaore");
		
		
		
	}
	public static void main(String[] args) {
		insert();

	}

}
