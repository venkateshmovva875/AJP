package com.actions;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.helper.FactoryProvider;
import com.model.pet;
import com.opensymphony.xwork2.ActionSupport;

public class adddetails extends ActionSupport {
    private pet Pet = new pet();

    public pet getPet() {
        return Pet;
    }

    public void setPet(pet Pet) {
        this.Pet = Pet;
    }

    public String create() {
        // Validate and process the form data
        if (Pet.getPetName() == null || Pet.getPetName().trim().isEmpty() ||
            Pet.getPetBreed() == null || Pet.getPetBreed().trim().isEmpty() ||
             Pet.getPetAge() == 0 || Pet.getPetType() == null) {
            addActionError("All fields are required");
            return ERROR;
        }

        Session session = FactoryProvider.getFactory().openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();

            // Persist the Pet object
            session.persist(Pet);

            tx.commit();
            addActionMessage("Pet created successfully!");
            return SUCCESS;
        } catch (Exception e) {
            // Rollback the transaction in case of an exception
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            // Handle any exceptions that occur during the pet creation process
            addActionError("Error creating pet details: " + e.getMessage());
            return ERROR;
        } finally {
            // Close the Hibernate session
            session.close();
        }
    }
}
