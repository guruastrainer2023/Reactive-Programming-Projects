package com.training.ui;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.training.bean.pack1.Candidate;
import com.training.util.HibernateUtil;

public class Main01_A {
	
	
	static void insert(){
		/*
		 * double[] scores={8.6, 9.1, 10.0}; Candidate candidate=new Candidate();
		 * candidate.setName("Sheela"); candidate.setCity("Bangalore");
		 * candidate.setMarks(scores);
		 */
		
		/*
		 * double[] scores={5.1, 9.0, 6.7}; Candidate candidate=new Candidate();
		 * candidate.setName("Priya"); candidate.setCity("Hyderabad");
		 * candidate.setMarks(scores);
		 */
		
		double[] scores={7.8, 5.0, 6.1}; Candidate candidate=new Candidate();
		candidate.setName("Sneha"); candidate.setCity("Chennai");
		candidate.setMarks(scores);
		
		
		Session session=HibernateUtil.getHibernateSession();
		Transaction tx=session.beginTransaction();
		
		session.persist(candidate);
		
		tx.commit();
		
		System.out.println("Candidate Stored");
		HibernateUtil.closeSession();
		
	}
	
	static void load() {
		Session session=HibernateUtil.getHibernateSession();
		Candidate candidate;
		candidate=session.find(Candidate.class, 1);
		
		System.out.println(candidate);
		HibernateUtil.closeSession();
	}
	
	static void loadAll() {
		Session session=HibernateUtil.getHibernateSession();
		
		Query<Candidate> candidateQuery=session.createQuery("from Candidate",Candidate.class);
		List<Candidate> candidateList=candidateQuery.getResultList();
		
		System.out.println(candidateList);
		HibernateUtil.closeSession();
	}
	
	static void update() {
		Session session=HibernateUtil.getHibernateSession();
		
		Candidate candidate;
		candidate=session.find(Candidate.class, 1);
		candidate.setName(candidate.getName().toUpperCase());
		candidate.setMarks(new double[] {3.0,4.0,5.0,6.0,7.0});
		
		Transaction tx=session.beginTransaction();
		
		session.merge(candidate);
		
		tx.commit();
		
		System.out.println("Candidate Updated");
	
		HibernateUtil.closeSession();
	}
	
	static void delete() {
		Session session=HibernateUtil.getHibernateSession();
		
		Candidate candidate;
		candidate=session.find(Candidate.class, 3);
		
		
		Transaction tx=session.beginTransaction();
		
		session.remove(candidate);
		
		tx.commit();
		
		System.out.println("Candidate Deleted");
	
		HibernateUtil.closeSession();
	}

	public static void main(String[] args) {
		//insert();
		
		//load();
		
		//loadAll();
		
		//update();
		
		//delete();

	}

}
