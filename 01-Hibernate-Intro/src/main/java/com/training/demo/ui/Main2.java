package com.training.demo.ui;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.training.demo.bean.Employee;
import com.training.demo.bean.Gender;
import com.training.demo.bean.Person;
import com.training.demo.commons.HibernateUtil;
import com.training.demo.commons.UIInputModule;

public class Main2 {

	static void insertObject() {

		Session session = HibernateUtil.getHibernateSession();

		Employee employee;
		// employee=new Employee("Priya", 15000.00, 'A',LocalDate.of(1998,4,10),
		// LocalDate.of(2018,6,12), false, Gender.FEMALE);
		// employee=new Employee("Gaurav", 14000.00, 'B',LocalDate.of(1997,3,20),
		// LocalDate.of(2019,8,5), false, Gender.MALE);
		// employee=new Employee("Abhishek Singh", 11000.00,
		// 'C',LocalDate.of(1999,2,10), LocalDate.of(2022,8,14), false, Gender.MALE);
		employee = new Employee("Mohit", 25000.00, 'A', LocalDate.of(1996, 10, 8), LocalDate.of(2015, 10, 12), true,
				Gender.MALE);
		session.getTransaction().begin();
		session.persist(employee);
		session.getTransaction().commit();

		HibernateUtil.closeSession();

	}

	static void loadObject() {
		Session session = HibernateUtil.getHibernateSession();

		Employee employee;
		employee = session.find(Employee.class, 4);
		System.out.println(employee);

		HibernateUtil.closeSession();
	}

	static void updateObject() {
		Session session = HibernateUtil.getHibernateSession();

		Employee employee;
		employee = session.find(Employee.class, 3);
		employee.setBasicSalary(employee.getBasicSalary()+1000);
		
		session.getTransaction().begin();
		session.merge(employee);
		session.getTransaction().commit();
		
		HibernateUtil.closeSession();
		
	}

	static void loadAllObjects() {
		Session session = HibernateUtil.getHibernateSession();

		Query<Employee> empQuery = session.createQuery("from Employee", Employee.class);
		List<Employee> employeeList = empQuery.getResultList();
		System.out.println(employeeList);

		HibernateUtil.closeSession();

	}

	static void deleteObject() {
		Session session = HibernateUtil.getHibernateSession();

		Employee employee;
		employee = session.find(Employee.class, 3);
		employee.setBasicSalary(employee.getBasicSalary()+1000);
		
		session.getTransaction().begin();
		session.remove(employee);
		session.getTransaction().commit();
		
		HibernateUtil.closeSession();
	}

	public static void main(String[] args) {
		// insertObject();

		// loadObject();

		// loadAllObjects();
		//updateObject();
		deleteObject();
		
	}

}
