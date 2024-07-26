package com.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class pet {
	@Id
    private String petName;
    private String petBreed;
    private int petAge;
    private String petType;

    // Constructors

    public pet() {
        // Default constructor
    }

    public pet(String petName, String petBreed, int petAge, String petType) {
        this.petName = petName;
        this.petBreed = petBreed;
        this.petAge = petAge;
        this.petType = petType;
    }

    // Getters and setters

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public String getPetBreed() {
        return petBreed;
    }

    public void setPetBreed(String petBreed) {
        this.petBreed = petBreed;
    }

    public int getPetAge() {
        return petAge;
    }

    public void setPetAge(int petAge) {
        this.petAge = petAge;
    }

    public String getPetType() {
        return petType;
    }

    public void setPetType(String petType) {
        this.petType = petType;
    }
}