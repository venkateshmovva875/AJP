package com.example;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.opensymphony.xwork2.ActionSupport;


public class UpdateTaskAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private Task task;

	public String post() {
		Session session = FactoryProvider.getFactory().openSession();
		Transaction tx = null;
		System.out.println("Id " + id);
		try {
			tx = session.beginTransaction();

			// Fetch the existing book from the database using book id
			
			Task existingTask = session.get(Task.class, id);

			if (existingTask != null) {
				// Update the book details
				
				existingTask.setId(id);
				existingTask.setName(task.getName());
				existingTask.setDescription(task.getDescription());
				existingTask.setDueDate(task.getDueDate());
				existingTask.setPriority(task.getPriority());

				// Save the changes
				session.merge(existingTask);

				tx.commit();
				addActionMessage("task updated successfully!");
				return SUCCESS;
			} else {
				addActionError("task with Id " + id + " not found.");
				return ERROR;
			}
		} catch (Exception e) {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
			addActionError("Error updating task: " + e.getMessage());
			return ERROR;
		} finally {
			session.close();
		}
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Task getTask() {
		return task;
	}

	public void setTask(Task task) {
		this.task = task;
	}

}