package com.shop.service;

import com.shop.entity.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ItemService {

    private List<Product> itemList = new ArrayList<>();

    public void addItem(Product item) {
        itemList.add(item);
    }

    public List<Product> getItemList() {
        return itemList;
    }

    public void clearItemList() {
        itemList.clear();
    }

    public void updateQuantity(String itemName, int newQuantity) {
        for (Product item : itemList) {
            if (item.getName().equals(itemName)) {
                item.setQuantity(newQuantity);
                break;
            }
        }
    }

    public double calculateTotalPrice() {
        double totalPrice = 0;
        for (Product item : itemList) {
            totalPrice += item.getPrice() * item.getQuantity();
        }
        return totalPrice;
    }

    public  double calculatetotalAmount() {
        double totalAmount = 0;
        for (Product item : itemList) {
            totalAmount += item.getPrice() ;
        }
        return totalAmount;
    }

}
