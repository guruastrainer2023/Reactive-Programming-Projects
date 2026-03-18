package com.training.ui;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.training.bean.pack2.Category;
import com.training.util.HibernateUtil;

public class Main3 {
	
	
	static void insert(){
		Category category1=new Category("Web");
		category1.add("html");
		category1.add("css");
		category1.add("js");
		
		Category category2=new Category("RDBMS");
		category2.add("Oracle 12c");
		category2.add("MySQL8");
		
		
	}

	public static void main(String[] args) {
		insert();
	}

}


