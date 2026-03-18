package com.training.demo.ui;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.training.demo.bean.Person;
import com.training.demo.commons.UIInputModule;

public class Main1 {

	static void insertObject1() {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();

		Person person = new Person(604, "Rashmi", "Nair", 25);

		session.getTransaction().begin();
		session.persist(person);
		session.getTransaction().commit();

		session.close();
		sessionFactory.close();

	}

	
	static void loadObject() {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		Person person=session.find(Person.class, 601);
		
		System.out.println(person);
		
		session.close();
		sessionFactory.close();

	}

	static void updateObject() {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		Person person=session.find(Person.class, 601);
		System.out.println(person);
		
		person.setAge(person.getAge()+1);
		person.setFirstName(person.getFirstName().toUpperCase());
		person.setLastName(person.getLastName().toUpperCase());
		
		session.getTransaction().begin();
		session.merge(person);
		session.getTransaction().commit();
		
		System.out.println(person);
		
		session.close();
		sessionFactory.close();
	}

	static void loadAllObjects() {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		Query<Person> personsQuery=session.createQuery("from Person", Person.class);
		
		List<Person> allPersons= personsQuery.getResultList();
		
		System.out.println(allPersons);
		
		session.close();
		sessionFactory.close();
		
	}

	static void deleteObject() {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		Person person=session.find(Person.class, 601);
		System.out.println(person);
		
		
		
		session.getTransaction().begin();
		session.remove(person);
		session.getTransaction().commit();
		
		System.out.println(person + " is Removed from DB.!");
		
		session.close();
		sessionFactory.close();
	}

	public static void main(String[] args) {

		//insertObject1();
		//loadObject();
		//updateObject();
		//deleteObject();
		
		loadAllObjects();

	}

}
