package com.training.ui;

import java.util.Set;
import java.util.TreeSet;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.training.bean.pack2.Course;
import com.training.bean.pack2.Subject;
import com.training.util.HibernateUtil;



public class Main2 {

	private static void insertTesting() {
		
		Course course=new Course("Induction Training", 32000.00);
		
		course.addSubject(new Subject("Spring", 42));
		course.addSubject(new Subject("JPA", 18));
		course.addSubject(new Subject("JQuery", 20));
		course.addSubject(new Subject("Angular JS", 50));
		course.addSubject(new Subject("Ajax", 5));
		
		HibernateUtil.init();
		Session session=HibernateUtil.getSession();
		Transaction tx=session.beginTransaction();
		
		session.save(course);
		
		tx.commit();
		HibernateUtil.cleanUp();
		
		
		
		
		
		System.out.println("\t\t !>>>>>>>>>>> course Data Saved <<<<<<<<<<<<<<!");
	}

	private static void loadTesting() {
		
		HibernateUtil.init();
		Session session=HibernateUtil.getSession();
		
		Course course=session.load(Course.class, 1);
		System.out.println(course);
		
		HibernateUtil.cleanUp();


	}

	private static void editTesting() {
		HibernateUtil.init();
		Session session=HibernateUtil.getSession();
		Transaction tx=session.beginTransaction();
		
		Course course=session.load(Course.class, 1);
		System.out.println(course);
		
		course.setFee(course.getFee()+3000);
		course.setCourseName(course.getCourseName().toUpperCase());
		
		course.getSubjects().remove(session.load(Subject.class, 2));
		course.getSubjects().add(new Subject(" React JS",24));
		
		session.update(course);
		
		tx.commit();
		HibernateUtil.cleanUp();

	}

	private static void deleteTesting() {
		HibernateUtil.init();
		Session session=HibernateUtil.getSession();
		Transaction tx=session.beginTransaction();
		
		
		tx.commit();
		HibernateUtil.cleanUp();

	}

	private static void loadAllTesting() {

		HibernateUtil.init();
		Session session=HibernateUtil.getSession();
		
		HibernateUtil.cleanUp();

	}

	public static void main(String[] args) {
		insertTesting();
		

	}

}
