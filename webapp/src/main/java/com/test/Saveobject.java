package com.test;

import java.security.PublicKey;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.models.comments;
import com.models.posts;
import com.models.users;
import com.utility.Utility;

public class Saveobject {

	public static int save(users user)
	{
		Session session = Utility.getSession();
		Transaction txTransaction = null;
		Integer count=0;
		try(session){
			txTransaction=session.beginTransaction();
			count=(Integer)session.save(user);
			txTransaction.commit();
		}catch (HibernateException he) {
			// TODO: handle exception
			he.printStackTrace();
			txTransaction.rollback();
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			txTransaction.rollback();
		}
		return count;
	}
  public static int savepost(posts post) {
	  Session session = Utility.getSession();
		Transaction txTransaction = null;
		Integer count=0;
		try(session){
			txTransaction=session.beginTransaction();
			count=(Integer)session.save(post);
			txTransaction.commit();
		}catch (HibernateException he) {
			// TODO: handle exception
			he.printStackTrace();
			txTransaction.rollback();
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			txTransaction.rollback();
		}
		return count;
  }
  public static int savecomment(comments comment) {

	    Session session = Utility.getSession();
	    Transaction txTransaction = null;
	    Integer count = 0;

	    try (session) {
	        txTransaction = session.beginTransaction();
	        count = (Integer) session.save(comment);
	        txTransaction.commit();
	    } catch (HibernateException he) {
	        // TODO: handle exception
	        he.printStackTrace();
	        txTransaction.rollback();
	    } catch (Exception e) {
	        // TODO: handle exception
	        e.printStackTrace();
	        txTransaction.rollback();
	    }

	    return count;
	}
 
}
