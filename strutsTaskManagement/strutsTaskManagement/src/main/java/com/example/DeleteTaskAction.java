package com.example;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.opensymphony.xwork2.ActionSupport;

public class DeleteTaskAction extends ActionSupport {
	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String post() {
		Session session = FactoryProvider.getFactory().openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();

			// Load the existing book from the database using ID
			Task existingTask = session.get(Task.class, id);

			if (existingTask != null) {
				// Delete the book
				session.remove(existingTask);

				tx.commit();
				addActionMessage("Task deleted successfully!");
				return SUCCESS;
			} else {
				addActionError("Task not found with ID: " + id);
				return ERROR;
			}
		} catch (Exception e) {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
			addActionError("Error deleting Task: " + e.getMessage());
			return ERROR;
		} finally {
			session.close();
		}
	}
}