package com.shop.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "cart")
public class Order {
    
    private int id;
    private int product_id;
    private String product_name;
    private int quantity;
    private Double price;
}
