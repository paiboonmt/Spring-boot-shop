package com.shop.repository;

import com.shop.entity.Cart;
import com.shop.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepositoty extends JpaRepository<Order ,Long> {
    void delete(Cart cart);
}
