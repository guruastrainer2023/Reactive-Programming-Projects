package com.training.ui;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.training.bean.pack1.Candidate;
import com.training.bean.pack1.Question;
import com.training.util.HibernateUtil;

public class Main01_B {
	
	
	static void insert(){
		
		/*
		 * String[] answers= {"Method Overriding", "Method Overloading"}; Question
		 * question=new Question("Runtime Polymorphism is implemented using", 1,
		 * answers);
		 */
		/*
		 * String[] answers= {"YES", "NO"}; Question question=new
		 * Question("Is Java Language Platform Independent", 1, answers);
		 */
		String[] answers= {"try", "catch", "finally", "throw", "throws"};
		Question question=new Question("Which of the following keywords are used for Exception Handling?", 2, answers);
		
		
		Session session=HibernateUtil.getHibernateSession();
		Transaction tx=session.beginTransaction();
		
		session.persist(question);
		
		tx.commit();
		
		System.out.println("Question Stored");
		HibernateUtil.closeSession();
		
	}
	
	static void load() {
		Session session=HibernateUtil.getHibernateSession();
		
		Question question;
		question=session.find(Question.class, 3);
		
		System.out.println(question);
		HibernateUtil.closeSession();
	}
	
	static void loadAll() {
		Session session=HibernateUtil.getHibernateSession();
		
		Query<Question> questionQuery=session.createQuery("from Question",Question.class);
		List<Question> candidateList=questionQuery.getResultList();
		
		System.out.println(candidateList);
		HibernateUtil.closeSession();
	}
	
	static void update() {
		Session session=HibernateUtil.getHibernateSession();
		
		Question question;
		question=session.find(Question.class, 3);
		
		question.setMark(5);
		
		Transaction tx=session.beginTransaction();
		
		session.merge(question);
		
		tx.commit();
		
		System.out.println("Question Updated");
	
		HibernateUtil.closeSession();
	}
	
	static void delete() {
Session session=HibernateUtil.getHibernateSession();
		
		Question question;
		question=session.find(Question.class, 3);
		
		
		
		Transaction tx=session.beginTransaction();
		
		session.remove(question);
		
		tx.commit();
		
		System.out.println("Question Removed");
	
		HibernateUtil.closeSession();
	}

	public static void main(String[] args) {
		//insert();
		
		//load();
		
		//loadAll();
		
		//update();
		
		delete();

	}

}
