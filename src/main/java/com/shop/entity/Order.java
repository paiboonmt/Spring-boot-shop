package com.shop.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "orderItem")
public class Order {

    @Id
    @GeneratedValue
    private int cartId;
    private String orderId;
    private int productId;
    private String productName;
    private int quantity;
    private double price;
    private int userId;
    private int status;

    public Order() {
        super();
    }

    public Order(String orderId, int productId, String productName, int quantity, double price, int userId, int status) {
        this.orderId = orderId;
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
        this.userId = userId;
        this.status = status;
    }

    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Order{" +
                "cartId=" + cartId +
                ", orderId='" + orderId + '\'' +
                ", productId=" + productId +
                ", productName='" + productName + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                ", userId=" + userId +
                ", status=" + status +
                '}';
    }
}
