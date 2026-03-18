package com.training.demo.ui;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.training.demo.bean.Contact;
import com.training.demo.bean.Person;
import com.training.demo.commons.HibernateUtil;

public class Main3 {

	static void insertObject() {
		Session session = HibernateUtil.getHibernateSession();

		session.getTransaction().begin();

		Contact contact;
		// contact=new Contact("Ram", "Gupta");
		// contact=new Contact("Gaurav", "Sharma");
		contact = new Contact("Mohit", "Varma");

		session.persist(contact);

		session.getTransaction().commit();

		HibernateUtil.closeSession();

	}

	static void loadObject() {
		Session session = HibernateUtil.getHibernateSession();
		Contact contact = session.find(Contact.class, 2);
		System.out.println(contact);
		HibernateUtil.closeSession();
	}

	static void updateObject() {

		Session session = HibernateUtil.getHibernateSession();

		session.getTransaction().begin();

		Contact contact=session.find(Contact.class, 2);
		System.out.println(contact);
		contact.setFirstName(contact.getFirstName().toUpperCase());
		contact.setLastName(contact.getLastName().toUpperCase());
		
		session.merge(contact);
		System.out.println(contact);
		session.getTransaction().commit();
		
		HibernateUtil.closeSession();
		
		
	}

	static void loadAllObjects() {
		Session session = HibernateUtil.getHibernateSession();

		Query<Contact> contactQuery = session.createQuery("from Contact", Contact.class);

		List<Contact> allContacts = contactQuery.getResultList();

		System.out.println(allContacts);

		HibernateUtil.closeSession();
	}

	static void deleteObject() {
		Session session = HibernateUtil.getHibernateSession();

		session.getTransaction().begin();

		Contact contact=session.find(Contact.class, 2);
		System.out.println(contact);
		
		
		session.remove(contact);
		System.out.println(contact + " is deleted from Database !");
		session.getTransaction().commit();
		
		HibernateUtil.closeSession();
	}

	public static void main(String[] args) {
		// insertObject();
		// loadObject();
		//loadAllObjects();
		//updateObject();
		deleteObject();

	}

}
