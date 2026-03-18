package com.training.ui;



import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.training.bean.Doctor;
import com.training.util.HibernateUtil;

public class Main5 {
	
	static void delete1() {
		String str = "delete from Doctor where id=:id";
		
		HibernateUtil.init();
		Session session=HibernateUtil.getSession();
		
		Query query=session.createQuery(str);
		query.setParameter("id", 2);
		
		Transaction tx=session.beginTransaction();
		int r=query.executeUpdate();
		tx.commit();
		
		System.out.println(r);
		
		HibernateUtil.cleanUp();
		
	}
	static void update1() {
		String str = "update Doctor set fees=:fees where id=:id";

		HibernateUtil.init();
		Session session = HibernateUtil.getSession();

		Transaction tx=session.beginTransaction();
		
		Query query=session.createQuery(str);
		query.setParameter("fees", 2500.00);
		query.setParameter("id", 3);
		
		int r=query.executeUpdate();
		System.out.println(r);
		
		tx.commit();
		
		HibernateUtil.cleanUp();
		

		
	}
	public static void main(String[] args) {
		update1();

	}

}
