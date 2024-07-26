package com.actions;

import com.opensymphony.xwork2.ActionSupport;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.helper.FactoryProvider;
import com.vignan.Employee;

public class updateEmployeeAction extends ActionSupport {
    private int id;
    private String firstName;
    private String lastName;

    public String update() {
        Session session = FactoryProvider.getFactory().openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            Employee employee = session.get(Employee.class, id);

            if (employee != null) {
                // Update employee information
                employee.setFirstName(firstName);
                employee.setLastName(lastName);
                session.merge(employee);
                tx.commit();
                addActionMessage("Employee updated successfully!");
                return SUCCESS;
            } else {
                addActionError("Employee with ID " + id + " not found.");
                return ERROR;
            }
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            addActionError("Error updating employee: " + e.getMessage());
            return ERROR;
        } finally {
            session.close();
        }
    }

    // Getters and setters for form fields
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
