package com.example;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.opensymphony.xwork2.ActionSupport;

public class AddTaskAction extends ActionSupport {

    private static final long serialVersionUID = 1L;

    private Task task;

    public String post() {
        Session session = null;
        Transaction tx = null;

        try {
            session = FactoryProvider.getFactory().openSession();
            tx = session.beginTransaction();
            session.persist(task);
            tx.commit();
            addActionMessage("Task added successfully!");
            return SUCCESS;
        } catch (Exception e) {
            // Rollback the transaction in case of an exception
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            // Handle any exceptions that occur during the task addition process
            addActionError("Error adding task: " + e.getMessage());
            return ERROR;
        } finally {
            // Close the Hibernate session
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }
}
