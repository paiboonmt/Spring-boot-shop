package com.shop.service;


import com.shop.entity.Cart;
import com.shop.entity.Order;
import com.shop.repository.OrderRepositoty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private OrderRepositoty repo;

    public void additem(Order order){
        repo.save(order);
    }

    public void removeOrder(Cart cart){
        repo.delete(cart);
    }

}
