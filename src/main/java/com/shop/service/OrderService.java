package com.shop.service;

import com.shop.entity.Order;
import com.shop.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public Order save(Order order) {
        return orderRepository.save(order);
    }

    public Order findById(int id) {
        Optional<Order> order = orderRepository.findById(id);
        return order.orElse(null);
    }

    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    public void delete(int id) {
        orderRepository.deleteById(id);
    }

    public void count(){
        orderRepository.count();
    }

}
