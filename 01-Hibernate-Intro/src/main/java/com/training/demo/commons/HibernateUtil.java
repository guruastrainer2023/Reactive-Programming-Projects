package com.training.demo.commons;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static SessionFactory sessionFactory;
	private static Session session;
	
	public static Session getHibernateSession() {
		if(sessionFactory==null) {
			sessionFactory=new Configuration().configure().buildSessionFactory();
		}
		if(session==null) {
			session=sessionFactory.openSession();
		}
		return session;
	}
	
	public static void closeSession() {
		if(session!=null)
			session.close();
		if(sessionFactory!=null)
			sessionFactory.close();
	}
}
