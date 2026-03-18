package com.training.ui;

import java.time.LocalDate;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.training.bean.Doctor;
import com.training.util.HibernateUtil;


public class Main1 {

	public static void main(String[] args) {
		Doctor doctor1=new Doctor("Santhosh", 500, "MALE", LocalDate.of(2006, 12, 15));
		Doctor doctor2=new Doctor("Abhi", 1000, "FEMALE", LocalDate.of(2005, 5, 24));
		Doctor doctor3=new Doctor("Sheela", 800, "FEMALE", LocalDate.of(1998, 2, 20));
		Doctor doctor4=new Doctor("Vikram", 600, "MALE", LocalDate.of(2018, 6, 18));
		Doctor doctor5=new Doctor("Ramesh", 850, "MALE", LocalDate.of(2000, 1, 22));
		
		HibernateUtil.init();
		
		Session session=HibernateUtil.getSession();
		
		Transaction tx=session.beginTransaction();
		session.save(doctor1);
		session.save(doctor2);
		session.save(doctor3);
		session.save(doctor4);
		session.save(doctor5);
		tx.commit();
		System.out.println("Doctor Data Saved ");
		HibernateUtil.cleanUp();

	}

}
