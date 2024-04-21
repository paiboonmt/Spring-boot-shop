package com.shop.entity;

import jakarta.persistence.*;
import org.springframework.web.bind.annotation.RequestParam;

@Entity
@Table(name = "cartorder")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String tex;
    private String date;
    private String totalPrice;

    public Order() {
        super();
    }

    public Order(String tex, String date,  String totalPrice, int id) {
        this.tex = tex;
        this.date = date;
        this.totalPrice = totalPrice;
        this.id = id;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", tex=" + tex +
                ", date='" + date + '\'' +
                ", totalPrice='" + totalPrice + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTex() {
        return tex;
    }

    public void setTex(String tex) {
        this.tex = tex;
    }


    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(String totalPrice) {
        this.totalPrice = totalPrice;
    }
}
