package com.training.ui;

import org.hibernate.Session;

import com.training.bean.pack2.Book;
import com.training.util.HibernateUtil;

public class Main02_A {

	static void insert() {
		Session session = HibernateUtil.getHibernateSession();

		Book book = new Book("SCJP Certification Guide", "Kathy Sierra");
		book.addTopic("Java Fundamentals");
		book.addTopic("OOPS Concepts");
		book.addTopic("Polymorphism");
		book.addTopic("Collection API");

		session.getTransaction().begin();

		session.persist(book);

		session.getTransaction().commit();

		HibernateUtil.closeSession();
	}

	static void read() {
		Session session = HibernateUtil.getHibernateSession();

		Book book;
		book = session.find(Book.class, 1);

		System.out.println(book);

		HibernateUtil.closeSession();
	}

	static void readAll() {

	}

	static void update() {
		Session session = HibernateUtil.getHibernateSession();

		Book book;
		book = session.find(Book.class, 1);
		
		book.setBookName(book.getBookName().toUpperCase());
		book.getTopics().remove(book.getTopics().size()-1);

		System.out.println(book);
		session.getTransaction().begin();

		session.merge(book);

		session.getTransaction().commit();
		
		

		HibernateUtil.closeSession();
	}

	

	static void delete() {
		Session session = HibernateUtil.getHibernateSession();

		Book book;
		book = session.find(Book.class, 1);
		
		book.setBookName(book.getBookName().toUpperCase());

		System.out.println(book);
		session.getTransaction().begin();

		session.remove(book);

		session.getTransaction().commit();
		
		

		HibernateUtil.closeSession();
	}

	public static void main(String[] args) {
		// insert();
		//read();
		//update();
		
		delete();

	}

}
