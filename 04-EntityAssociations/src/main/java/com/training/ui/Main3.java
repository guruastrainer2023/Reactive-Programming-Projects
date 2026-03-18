package com.training.ui;

import java.time.LocalDate;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.training.bean.pack3.ContactInfo;
import com.training.bean.pack3.Person;
import com.training.util.HibernateUtil;

public class Main3 {
	static void test1() {
		Person person = new Person(101, "John", LocalDate.of(1998, 2, 20), 'M', null);

		ContactInfo contactInfo = new ContactInfo("John@gmail.com", "9764736738", null);
		person.setContactInfo(contactInfo);
		contactInfo.setPerson(person);

		HibernateUtil.init();
		Session session = HibernateUtil.getSession();

		Transaction tx = session.beginTransaction();
		session.save(person);
		tx.commit();

		HibernateUtil.cleanUp();

	}

	static void test2() {
		Person person = new Person(102, "Jeya", LocalDate.of(2002, 2, 12), 'F', null);

		HibernateUtil.init();
		Session session = HibernateUtil.getSession();

		Transaction tx = session.beginTransaction();
		session.save(person);
		tx.commit();

		HibernateUtil.cleanUp();

	}

	static void test3() {
		ContactInfo contactInfo = new ContactInfo("Jeya2001@gmail.com", "8765819103", null);

		HibernateUtil.init();
		Session session = HibernateUtil.getSession();

		Person person = session.load(Person.class, 102);
		contactInfo.setPerson(person);
		person.setContactInfo(contactInfo);

		Transaction tx = session.beginTransaction();
		session.save(contactInfo);
		tx.commit();
		HibernateUtil.cleanUp();

	}

	static void test4() {

		HibernateUtil.init();
		Session session = HibernateUtil.getSession();

		Person person = session.load(Person.class, 102);
		System.out.println(person);
		System.out.println(person.getContactInfo());
		
		HibernateUtil.cleanUp();

	}

	static void test5() {
		HibernateUtil.init();
		Session session = HibernateUtil.getSession();

		ContactInfo contactInfo=session.load(ContactInfo.class, 102);
		System.out.println(contactInfo);
		System.out.println(contactInfo.getPerson());
		
		HibernateUtil.cleanUp();
	}

	static void test6() {
		HibernateUtil.init();
		Session session = HibernateUtil.getSession();

		Person person = session.load(Person.class, 101);
		
		Transaction tx=session.beginTransaction();
		session.delete(person);
		tx.commit();
		
		HibernateUtil.cleanUp();
	}

	static void test7() {
		HibernateUtil.init();
		Session session = HibernateUtil.getSession();

		ContactInfo contactInfo=session.load(ContactInfo.class, 102);
		Transaction tx=session.beginTransaction();
		session.delete(contactInfo);
		tx.commit();
		
		HibernateUtil.cleanUp();
	}

	public static void main(String[] args) {

		test7();
	}

}
