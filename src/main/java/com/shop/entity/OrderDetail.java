package com.shop.entity;

import jakarta.persistence.*;

@Entity
@Table( name = "orderdetail")
public class OrderDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String tex;
    private int productId;
    private String product;
    private Double price;
    private int quantity;

    public OrderDetail() {
        super();
    }

    public OrderDetail(String  textId, int productId, String product, Double price, int quantity) {
        this.tex = textId;
        this.productId = productId;
        this.product = product;
        this.price = price;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "OrderDetail{" +
                "id=" + id +
                ", textId=" + tex +
                ", productId=" + productId +
                ", product='" + product + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
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

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setTextId(String tex) {
        this.tex = tex;
    }

    public void getPrice(Double price) {
        this.price = price;
    }
}
