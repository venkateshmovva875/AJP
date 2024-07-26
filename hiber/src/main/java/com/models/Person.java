package com.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Person {
@Id
 private String nameString;
 private String ageString;
 private String dobString;
public String getNameString() {
	return nameString;
}
public void setNameString(String nameString) {
	this.nameString = nameString;
}
public String getAgeString() {
	return ageString;
}
public void setAgeString(String ageString) {
	this.ageString = ageString;
}
public String getDobString() {
	return dobString;
}
public void setDobString(String dobString) {
	this.dobString = dobString;
}
public Person() {
   
}

public Person(String nameString, String ageString, String dobString) {
	super();
	this.nameString = nameString;
	this.ageString = ageString;
	this.dobString = dobString;
}
 
}
