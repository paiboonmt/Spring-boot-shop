package com.shop.service;

import com.shop.entity.Cart;
import com.shop.entity.Product;
import com.shop.repository.CartRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {

    @Autowired
    private CartRepo repo;

    public void addCart(Cart cart)
    {
        repo.save(cart);
    }

    public List<Cart> carts() {

        return repo.findAll();
    }

    
}
