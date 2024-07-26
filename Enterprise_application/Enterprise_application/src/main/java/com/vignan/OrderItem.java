package com.vignan;

import jakarta.persistence.*;

@Entity
@Table(name = "order_items")
public class OrderItem {
    
    @Id
    private Long id; 

    @Column(name = "item_id") 
    private Long itemId; 

    // Constructors, getters, and setters
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public OrderItem( Long itemId) {
        this.itemId = itemId;
    }

    public OrderItem() {
        // Default constructor
    }
}
