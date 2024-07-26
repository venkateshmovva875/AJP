package com.vignan.hibernate.AnnotationDemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

		Employee e1 = new Employee(23, "maruthi", "Venkat");
		Employee e2 = new Employee(21, "eswar", "venkat");
		System.out.println(e1);
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();

		session.persist(e2);
		tx.commit();
		factory.close();
	}

}
