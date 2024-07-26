package com.example;

import java.util.Date;
import jakarta.persistence.*;

@Entity
@Table(name = "tasks")
public class Task {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name = "TaskName")
    private String name;
	@Column(name = "Description")
    private String description;
	@Column(name = "Due Date")
    private Date dueDate; // Changed to Date type
	@Column(name = "Priority")
    private int priority;

    // Constructor
    
    public Task(int id, String name, String description, Date dueDate, int priority) {
        super();
        this.id = id;
    	this.name = name;
        this.description = description;
        this.dueDate = dueDate;
        this.priority = priority;
    }
    
    public Task() {
    	super();
    }
    
    // Getter and Setter methods
    
    
    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "Task{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", dueDate=" + dueDate +
                ", priority=" + priority +
                '}';
    }
}
