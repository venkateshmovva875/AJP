package com.models;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.Utility.utility;

public class PersonDao {
	public static int saveperson(Person person) throws HibernateException {
		Session session=utility.getSession();
		Transaction tx = session.beginTransaction();
		int count=0;

    try {
		  	session.save(person);
		  	count++;
			tx.commit();
		}
    	catch (Exception e) {
    		e.printStackTrace();
    		tx.rollback();
		}
	return count;
	}
}
