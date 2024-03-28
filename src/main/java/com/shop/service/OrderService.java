package com.shop.service;

import com.shop.entity.Cart;
import com.shop.entity.Order;
import com.shop.repository.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private OrderRepo repo;

    public void addOrder(Order order){
        repo.save(order);
    }
}
