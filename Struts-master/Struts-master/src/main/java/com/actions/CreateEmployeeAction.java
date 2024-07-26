package com.actions;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.helper.FactoryProvider;
import com.opensymphony.xwork2.ActionSupport;
import com.vignan.Employee;

public class CreateEmployeeAction extends ActionSupport {
	Employee employee = new Employee();

	public String create() {

		Session session = FactoryProvider.getFactory().openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			session.persist(employee);
			tx.commit();
			addActionMessage("Employee created successfully!");
			return SUCCESS;
		} catch (Exception e) {
			// Rollback the transaction in case of an exception
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
			// Handle any exceptions that occur during the employee creation process
			addActionError("Error creating employee: " + e.getMessage());
			return ERROR;
		} finally {
			// Close the Hibernate session
			session.close();
		}
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
}
