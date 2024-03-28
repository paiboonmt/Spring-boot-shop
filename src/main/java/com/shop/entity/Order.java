package com.shop.entity;
import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int order_id;
    private Double total_price;
    private String uder_id;
    private Date date;

    public Order() {
        super();
    }

    @Override
    public String toString() {
        return "Order{" +
                "order_id=" + order_id +
                ", total_price=" + total_price +
                ", uder_id='" + uder_id + '\'' +
                ", date=" + date +
                '}';
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public Double getTotal_price() {
        return total_price;
    }

    public void setTotal_price(Double total_price) {
        this.total_price = total_price;
    }

    public String getUder_id() {
        return uder_id;
    }

    public void setUder_id(String uder_id) {
        this.uder_id = uder_id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
