package com.training.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {
	
	private static SessionFactory sessionFactory=null;
	private static Session session=null;
	
	public static void init(){
		if(sessionFactory==null){
			ServiceRegistry registry;
			
			registry = new StandardServiceRegistryBuilder().configure().build();
			MetadataSources metaSources = new MetadataSources(registry);
			Metadata metaData = metaSources.getMetadataBuilder().build();
			sessionFactory = metaData.getSessionFactoryBuilder().build();
			
			session=sessionFactory.openSession();
		}
	}
	
	public static Session getSession(){
		return session;
	}
	
	public static void cleanUp(){
		session.close();
		sessionFactory.close();
	}

}
