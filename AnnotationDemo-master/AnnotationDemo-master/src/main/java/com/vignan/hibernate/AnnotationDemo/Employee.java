package com.vignan.hibernate.AnnotationDemo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Employee {
	@Id
	int id;
	private String firstnname, lastname;

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(int id, String firstnname, String lastname) {
		super();
		this.id = id;
		this.firstnname = firstnname;
		this.lastname = lastname;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstnname() {
		return firstnname;
	}

	public void setFirstnname(String firstnname) {
		this.firstnname = firstnname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstnname=" + firstnname + ", lastname=" + lastname + "]";
	}
	

}
