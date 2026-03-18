package com.training.demo.ui;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.training.demo.bean.Address;
import com.training.demo.bean.Person;
import com.training.demo.bean.Student;
import com.training.demo.commons.HibernateUtil;

public class Main4 {
	
	static void insertObject() {
		Session session=HibernateUtil.getHibernateSession();
		
		/*Student student=new Student("Abinaya", 86);
		Address address=new Address("D-12", "5th Street", "Rose Garden", "Mumbai", "400050");
		student.setAddress(address);*/
		
		
		/*Student student=new Student("Chithra", 92);
		Address address=new Address("Plot 120 F-2", "2nd Main Road", "Velacherry", "Chennai", "600000");
		student.setAddress(address);*/
		
		Student student=new Student("John", 88);
		Address address=new Address("FF-10", "RTO Office Road", "Habsiguda", "Hyderabad", "500001");
		student.setAddress(address);
		
		session.getTransaction().begin();
		session.persist(student);
		
		session.getTransaction().commit();
		HibernateUtil.closeSession();
	}

	
	static void loadObject() {
		Session session=HibernateUtil.getHibernateSession();
		Student student=session.find(Student.class, 2);
		System.out.println(student);
		HibernateUtil.closeSession();
	}
	

	static void updateObject() {
		Session session=HibernateUtil.getHibernateSession();
		Student student=session.find(Student.class, 2);
		System.out.println(student);
		student.setMarks(student.getMarks()+2);
		student.getAddress().setAreaName("Nethaji nagar");
		
		session.getTransaction().begin();
		session.merge(student);
		session.getTransaction().commit();
		HibernateUtil.closeSession();
	}

	static void loadAllObjects() {
		Session session=HibernateUtil.getHibernateSession();
		
		
		Query<Student> studentQuery=session.createQuery("from Student", Student.class);
		
		List<Student> studentList=studentQuery.getResultList();
		
		System.out.println(studentList);
		
		HibernateUtil.closeSession();
	}

	static void deleteObject() {
		Session session=HibernateUtil.getHibernateSession();
		Student student=session.find(Student.class, 2);
		System.out.println(student);
		
		session.getTransaction().begin();
		session.remove(student);
		
		session.getTransaction().commit();
		
		System.out.println(student + " is removed from DB");
		HibernateUtil.closeSession();
	}

	public static void main(String[] args) {
		//insertObject();
		
		//loadObject();
		//loadAllObjects();
		//updateObject();
		deleteObject();
	}
}
