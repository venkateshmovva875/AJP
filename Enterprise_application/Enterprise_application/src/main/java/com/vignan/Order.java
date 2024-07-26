package com.vignan;

import jakarta.persistence.*;

@Entity
@Table(name = "orders")
public class Order {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) // Use GenerationType.AUTO for automatic ID generation
    private Long id;


    // other attributes, constructors, getters, setters
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Order(Long id) {
        super();
        this.id = id;
    }

    public Order() {
        super();
        // TODO Auto-generated constructor stub
    }
}
