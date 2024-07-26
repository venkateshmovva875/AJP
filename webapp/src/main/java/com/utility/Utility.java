package com.utility;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.internal.build.AllowSysOut;

public class Utility {
	static SessionFactory factory=null;
	static {
		 factory = new Configuration().configure("com/models/hibernate.cfg.xml").buildSessionFactory();
	}
	public static SessionFactory getSessionFactory()
	{
		return factory;
		
	}
	public static Session getSession()
	{
		Session session = factory.openSession();
		return session;
	}
	
}
