package com.actions;

import org.hibernate.Session;
import org.hibernate.Transaction;
import com.opensymphony.xwork2.ActionSupport;
import com.vignan.Employee;
import com.helper.FactoryProvider;

public class deleteEmployeeAction extends ActionSupport {
    private int id;

    public String delete() {
        Session session = FactoryProvider.getFactory().openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            Employee employee = session.get(Employee.class, id);

            if (employee != null) {
                // Delete the employee from the database
                session.remove(employee);
                tx.commit();
                addActionMessage("Employee deleted successfully!");
                return SUCCESS;
            } else {
                addActionError("Employee with ID " + id + " not found.");
                return ERROR;
            }
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            addActionError("Error deleting employee: " + e.getMessage());
            return ERROR;
        } finally {
            session.close();
        }
    }

    // Getter and setter for the ID
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
